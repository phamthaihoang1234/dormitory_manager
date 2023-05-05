package com.example.dormitory_manager.Controller;

import com.example.dormitory_manager.Repository.DomRepository;
import com.example.dormitory_manager.services.DomService;
import com.example.dormitory_manager.Services.RoomService;
import com.example.dormitory_manager.entities.Dom;
import com.example.dormitory_manager.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class DomController {
    @Autowired
    private DomService domService;



    @Autowired
    private DomRepository domRepository;


    @Autowired
    private RoomService roomService;






    @GetMapping("/homepageDom")
    public String homepageHotel(Model model) {
        model.addAttribute("doms", domService.findAll());

        return "domHompage";
    }




    @GetMapping("/showFormCreDom")
    public String showFormCreateDom(Model model) {
        model.addAttribute("dom", new Dom());
        return "form-add-dom";
    }



    @PostMapping("/createDom")
    public String showform(Model model, @ModelAttribute Dom dom) {
        domService.save(dom);
        return "redirect:/homepageDom";
    }


    @GetMapping("/findOne/{id}")
    public String findHotelById(@PathVariable("id") long id, Model model) {

        model.addAttribute("dom", domService.findById(id).get());
        return "form-edit-dom";
    }

    @PostMapping("/saveEdit")
    public String updateHotel(@ModelAttribute Dom dom) {
        Optional<Dom> oldDom = domService.findById(dom.getId());

        oldDom.get().setAddressOfDom(dom.getAddressOfDom());
        oldDom.get().setNameOfDom(dom.getNameOfDom());
        oldDom.get().setStatus(dom.getStatus());
        oldDom.get().setId(dom.getId());
        domService.save(dom);

        return "redirect:/homepageDom";
    }

    @GetMapping("/delete")
    public String deleteHotel(long id) {
        Dom dom = domService.findById(id).get();
        dom.setStatus(false);
        for (Room r: roomService.findAllByDomId(id)) {
            r.setCancelled(false);
            roomService.save(r);
        }
        domService.save(dom);
        return "redirect:/homepageDom";
    }

}
