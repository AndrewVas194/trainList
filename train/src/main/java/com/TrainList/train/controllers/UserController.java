package com.TrainList.train.controllers;

import com.TrainList.train.models.Role;
import com.TrainList.train.models.User;
import com.TrainList.train.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String userList(Model model){
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users",users);
        model.addAttribute("roles",Role.values());
        return "userList";
    }

    @GetMapping("{user}")
    public String userEdit(@PathVariable User user, Model model){
        model.addAttribute("user",user);
        model.addAttribute("roles",Role.values());
        return "userEdit";
    }

    /*@GetMapping("/remove/{user}")
    public String userDelete(@PathVariable User user, Model model) {
        Iterable<User> deleteUser = userRepository.findByUser(user);
        userRepository.deleteAll(deleteUser);
        user.getRoles().clear();
        userRepository.delete(user);
        model.addAttribute("user",user);
        return "redirect:/user";
    }*/

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ) {

        user.setUsername(username);
        Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepository.save(user);
        return "redirect:/user";
    }
}
