package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAllUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping("/userCreateForm")
    public String createUserForm(Model model) {
        model.addAttribute("users", new User());
        return "userCreateForm";
    }

    @PostMapping("/userCreateForm")
    public String createUser(User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/userDelete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/userEditForm/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("users", user);
        return "userEditForm";
    }

    @PostMapping("/userEditForm/{id}")
    public String editUser(User user) {
        userService.edit(user);
        return "redirect:/users";
    }


}

