package com.works.controllers;

import com.works.entities.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/loginUser")
    public String loginUser(Customer customer) {
        System.out.println(customer);
        return "redirect:/";
    }

}
