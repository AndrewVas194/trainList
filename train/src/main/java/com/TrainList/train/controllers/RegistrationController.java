package com.TrainList.train.controllers;

import com.TrainList.train.models.Role;
import com.TrainList.train.models.User;
import com.TrainList.train.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(Model model){
        return "registration";
    }



    @PostMapping("/registration")
    public String addUser(User user , Model model){
       User userFromdb = userRepository.findByUsername(user.getUsername());
       if(userFromdb !=null){
           model.addAttribute("message","User exists!");
           model.addAttribute("title","Error login");
           return "error-register";
       }

       user.setActive(true);
       user.setRoles(Collections.singleton(Role.USER));
       userRepository.save(user);
        model.addAttribute("message","New account!");
        model.addAttribute("title","New account");
        return "redirect:/login";
    }
}
