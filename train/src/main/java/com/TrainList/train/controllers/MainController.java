package com.TrainList.train.controllers;

import com.TrainList.train.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title","Sendtraining_Главная");
        return "home";
    }

    @GetMapping("/travel")
    public String travel(Model model){
        model.addAttribute("title","Путевки");
        return "travel";
    }

}