package com.example.dormitory_manager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.dormitory_manager.entities.Room;

import java.util.List;

@Controller
public class RoomController {
    @Autowired
    private RoomService service;

    @GetMapping("/room")
    public String listRoom(Model model) {
        List<Room> listRoom = service.listAll();
        model.addAttribute("listRoom", listRoom);
        return "room_manage";
    }

    @GetMapping("/room/new")
    public String newRoom(Model model) {
        model.addAttribute("room", new Room());
        model.addAttribute("pageTitle", "Add new room");
        return "new_room";
    }

    @PostMapping("/room/save")
    public String saveRoom(Room room, RedirectAttributes ra) {
        service.save(room);
        ra.addFlashAttribute("message", "Room has been saved successfully");
        return "redirect:/room";
    }

    @GetMapping("/room/edit&id={id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        try {
            Room room = service.get(id);
            model.addAttribute("pageTitle", "Edit room (id = " + id + ")");
            model.addAttribute("room", room);
            return "new_room";
        } catch (RoomNotFoundException e) {
            ra.addFlashAttribute("message", "Room has been saved successfully");
            return "redirect:/room";
        }
    }

    @GetMapping("/room/delete&id={id}")
    public String deleteRoom(@PathVariable("id") Long id, RedirectAttributes ra) {
        try {
            service.delete(id);     
            ra.addFlashAttribute("message", "The user ID = " + id + " has been deleted");   
        } catch (RoomNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/room";
    }
}
