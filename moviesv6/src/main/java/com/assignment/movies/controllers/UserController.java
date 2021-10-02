package com.assignment.movies.controllers;

import com.assignment.movies.entities.User;
import com.assignment.movies.services.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("users")
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;

    @GetMapping({"/signIn"})
    public String signIn(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signin";
    }

    @PostMapping("/register")
    public String insertUser(@ModelAttribute(name = "user") User u, Model model) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        String encodedPassword = bCryptPasswordEncoder.encode(u.getPassword());
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(u.getUsername(), encodedPassword, authorities);
        jdbcUserDetailsManager.createUser(user);
        service.updateUserEmail(u);
        return ("redirect:/users/signIn");
    }

    @GetMapping("/checkusername/{username}")
    @ResponseBody
    public String checkUsername(@PathVariable("username") String username) {
        User u = service.findByUserName(username);
        if (u != null) {
            return "Username exists";
        } else {
            return "All ok with Username";
        }
    }

    @GetMapping("/checkemail/{email}")
    @ResponseBody
    public String checkEmail(@PathVariable("email") String email) {
        User u = service.findByEmail(email);
        if (u != null) {
            return "Email exists";
        } else {
            return "All ok with Email";
        }
    }

    
}
