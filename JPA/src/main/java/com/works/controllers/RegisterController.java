package com.works.controllers;

import com.works.entities.Customer;
import com.works.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    final CustomerService customerService;

    @GetMapping("/")
    private String register(){
        return "register";
    }

    @PostMapping("/register")
    public String customerRegister(Customer customer) {
       Customer c = customerService.save(customer);
       System.out.println(c);
       return "redirect:/";
    }

}

