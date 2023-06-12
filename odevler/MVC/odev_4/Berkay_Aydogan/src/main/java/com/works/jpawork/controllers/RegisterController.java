package com.works.jpawork.controllers;

import com.works.jpawork.entities.User;
import com.works.jpawork.services.TinkEncDec;
import com.works.jpawork.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegisterController {
    final UserService userService;
    final TinkEncDec tinkEncDec;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/userSave")
    public String userSave(User user) {
     String chipherText = tinkEncDec.encrypt(user.getPassword());
     user.setPassword(chipherText);
     User u = userService.save(user);
     if(user != null && u.getUid() == null){
         System.out.println("Error");
     }else if(user != null && u.getUid() >0){
         System.out.println("Success");
        }
        return"redirect:/";
    }
}