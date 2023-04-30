package com.example.dormitory_manager.Controller;

import com.example.dormitory_manager.Repository.PropertyTypeRepository;
import com.example.dormitory_manager.Repository.RoomRepository;
import com.example.dormitory_manager.Services.DomService;
import com.example.dormitory_manager.Services.RoomService;
import com.example.dormitory_manager.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

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













    public Long idDom;


    @GetMapping("/manageRoom/{id}")
    public String homepageRoom(@PathVariable("id") Long id , Model model){
        idDom = id;

        return "redirect:/roomHomepage";
    }

    @GetMapping("/roomHomepage")
    public String homepageRoom(Model model){
        model.addAttribute("rooms",roomService.findAllByDomId(idDom));

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
        roomService.deleteById(id);
        return "redirect:/roomHomepage";
    }

    @GetMapping("/bookRoom")
    public String bookRoom(@ModelAttribute Room room){
        room.setStatus(false);
        roomService.save(room);
        return "redirect:/roomHomepage";
    }





}
