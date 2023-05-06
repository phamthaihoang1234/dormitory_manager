package com.example.dormitory_manager.Controller;

import com.example.dormitory_manager.Repository.PropertyTypeRepository;
import com.example.dormitory_manager.Repository.RoomRepository;

import com.example.dormitory_manager.Services.DomService;
import com.example.dormitory_manager.Services.RoomService;
import com.example.dormitory_manager.Services.UserService;
import com.example.dormitory_manager.entities.Room;
import com.example.dormitory_manager.entities.UserInfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashSet;
import java.util.Set;

@Controller
public class RoomController {








    @Autowired
    private DomService domService;




    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PropertyTypeRepository typeService;

    @Autowired
    private UserService userService;













    public Long idDom;


    @GetMapping("/manageRoom/{id}")
    public String homepageRoom(@PathVariable("id") Long id , Model model){
        idDom = id;

        return "redirect:/roomHomepage";
    }

    @GetMapping("/roomHomepage")
    public String homepageRoom(Model model){
        UserInfor userInfo = userService.findByUserName(getPrincipal());
        model.addAttribute("rooms",roomService.findAllByDomId(idDom));
        if(userInfo.getRoom() != null){
            model.addAttribute("idRoomOfUser",userInfo.getRoom().getId());
        }else {
            model.addAttribute("idRoomOfUser",-1);
        }

        return "roomHomepage";
    }



    @GetMapping("/createRoom")
    public String showFormCreateRoom( Model model){
        model.addAttribute("listProperty", typeService.findAll());
        Room room = new Room();
        room.setDom(domService.findById(idDom).get());
        model.addAttribute("room", room);

        return "form-add-room";
    }

    @PostMapping("/saveRoom")
    public String saveRoom(Model model, @ModelAttribute("room") Room room,@RequestParam("pr") Long id,RedirectAttributes redirect){
        room.setDom(domService.findById(idDom).get());
        room.setPropertyType(typeService.findById(id).get());




        roomService.save(room);
        model.addAttribute("rooms",roomService.findAllByDomId(idDom));


        return "roomHomepage";
    }

    @GetMapping("/findOneRoom/{id}")
    public String findRoomById(@PathVariable("id") long id , Model model){
        model.addAttribute("room", roomService.getOne(id));
        model.addAttribute("listProperty", typeService.findAll());
        return "form-edit-room";
    }

    @PostMapping("/saveEditRoom")
    public String updateRoom(@ModelAttribute Room room){


        roomService.save(room);


        return "redirect:/roomHomepage";
    }

    @GetMapping("/deleteRoom")
    public String deleteRoomById(long id){
        Room r = roomService.getOne(id).get();
        r.setCancelled(false);
        roomService.save(r);
        return "redirect:/roomHomepage";
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();

        } else {
            userName = principal.toString();
        }
        return userName;
    }

    @GetMapping("/bookRoom/{id}")
    public String bookRoom(@PathVariable("id") long id, RedirectAttributes redirect) throws Exception {
        Room room = roomService.getOne(id).get();
        UserInfor userInfo = userService.findByUserName(getPrincipal());

        Set<UserInfor> list = room.getUsers();

        if(room.getUsers().isEmpty()) {
             list = new HashSet<>();
        }else {
            for (UserInfor u: list) {
                if(u.getUsername() == userInfo.getUsername()){
                    redirect.addFlashAttribute("globalMessageBook", "You booked this room , you cannot book anymore.");
                    return "redirect:/roomHomepage";
                }
            }
        }

        if(userInfo.getRoom() != null){
            redirect.addFlashAttribute("globalMessageBook", "You booked another room , you cannot book anymore.");
            return "redirect:/roomHomepage";
        }


        userInfo.setRoom(room);
        room.setTotalOfNumberStudent(list.size()+1);



        if(room.getPropertyType().getId() == 1){
            if(room.getTotalOfNumberStudent() == 4){
                room.setStatus(false);


            }
        }

        if(room.getPropertyType().getId() == 2){
            if(room.getTotalOfNumberStudent() == 6){
                room.setStatus(false);


            }

        }
        userService.save(userInfo);
        redirect.addFlashAttribute("globalMessageBook", "Booking successfully.");
        return "redirect:/roomHomepage";
    }

    public UserInfor checkUserBooked(Set<UserInfor> list){
        UserInfor userInfo = userService.findByUserName(getPrincipal());
        for (UserInfor u: list) {
            if(u.getUsername() == userInfo.getUsername()){

                return u;
            }
        }
        return null;

    }

    @GetMapping("/returnRoom/{id}")
    public String returnRoom(@PathVariable("id") long id, RedirectAttributes redirect) throws Exception {
        Room room = roomService.getOne(id).get();
        UserInfor userInfo = userService.findByUserName(getPrincipal());
        int checkReturn = 0;

        Set<UserInfor> list = room.getUsers();

        UserInfor u = checkUserBooked(list);
        if(u != null){
            u.setRoom(null);
            list.remove(userService.findByUserName(getPrincipal()));
            room.setTotalOfNumberStudent(list.size());
            checkReturn = 1;
        }

        if(room.getPropertyType().getId() == 1){
            if(room.getTotalOfNumberStudent() == 4){
                room.setStatus(false);


            }else {
                room.setStatus(true);

            }

        }


        if(room.getPropertyType().getId() == 2){
            if(room.getTotalOfNumberStudent() == 6){
                room.setStatus(false);


            }else {
                room.setStatus(true);

            }

        }
        if(checkReturn == 1){
            redirect.addFlashAttribute("globalMessageBook", "Return room successfully.");

        }else {
            redirect.addFlashAttribute("globalMessageBook", "You dont book this room.");
        }

        userService.save(userInfo);
        return "redirect:/roomHomepage";

    }





}
