package com.works.controllers;

import com.works.props.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/userLogin")
    public String userLogin(User user) {
        System.out.println(user);
        return "redirect:/";
    }

}
