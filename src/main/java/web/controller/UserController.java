package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/users")
    public String printAllUsers(Model model) {
        model.addAttribute("allUsers",service.allUsers());
        return "users";
    }

    @GetMapping(value = "/add")
    public String addUserPage(@ModelAttribute("user") User user,Model model) {
        model.addAttribute("add",new User());
        return "add";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user) {
        service.addUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/edit/{id}")
    public String editUserPage(@PathVariable("id")Integer id, Model model) {
        model.addAttribute("user",service.getUserById(id));
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String editUser(@ModelAttribute("user") User user) {
        service.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUserPage(@PathVariable("id") Integer id) {
        User user = service.getUserById(id);
        service.deleteUser(user);
        return "redirect:/users";
    }
}
