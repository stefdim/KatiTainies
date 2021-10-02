package com.assignment.movies.controllers;

import com.assignment.movies.entities.User;
import com.assignment.movies.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    UserService userService;
    
    @GetMapping("/")
    public String adminCheckingUsers(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);
        return "admin";
    }
    
    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable(name = "username") String username, Model model) {
        
        if(userService.findByUserName(username)!=null) {
            userService.deleteUser(username);
        }
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return ("admin");
    }
    
    
    @PostMapping("/edit")
    public String editUserEnabled1(@RequestParam(name="username") String username,Model model){
        if(userService.findByUserName(username)!=null) {
            userService.updateUserEnabled(username);
        }
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return ("admin");
    }
    
}
