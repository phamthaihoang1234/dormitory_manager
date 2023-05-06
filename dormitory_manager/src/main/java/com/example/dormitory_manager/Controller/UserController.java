package com.example.dormitory_manager.Controller;

import com.example.dormitory_manager.Repository.UseRepository;
import com.example.dormitory_manager.Services.UserService;
import com.example.dormitory_manager.entities.UserInfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UseRepository useRepository;

    @GetMapping("/homepageUser")
    public String homepageUser(Model model) {
        model.addAttribute("users", userService.findAll());
        return "userHomepage";
    }

    @GetMapping("/showFormCreUser")
    public String showFormCreateUser(Model model) {
        model.addAttribute("user", new UserInfor());
        return "form-add-user";
    }

    @PostMapping("/createUser")
    public String createUser(Model model, @ModelAttribute UserInfor user) throws Exception {
        try {
            userService.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/homepageUser";
    }

    @GetMapping("/findOneUser/{id}")
    public String findUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findById(id).get());
        return "form-edit-user";
    }

    @PostMapping("/saveEditUser")
    public String updateUser(@ModelAttribute UserInfor user) {
        Optional<UserInfor> oldUser = userService.findById(user.getId());
        oldUser.get().setUsername(user.getUsername());
        oldUser.get().setPassword(user.getPassword());
        oldUser.get().setName(user.getName());
        oldUser.get().setEmail(user.getEmail());
        oldUser.get().setRoles(user.getRoles());
        oldUser.get().setId(user.getId());
        try {
            userService.save(oldUser.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/homepageUser";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(long id) {
        UserInfor user = userService.findById(id).get();
        user.setEnabled(false);
        try {
            userService.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/homepageUser";
    }
}
