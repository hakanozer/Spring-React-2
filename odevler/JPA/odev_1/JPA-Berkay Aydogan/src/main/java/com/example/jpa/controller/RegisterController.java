package com.example.jpa.controller;

import com.example.jpa.entities.Customer;
import com.example.jpa.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegisterController {
    final CustomerService customerService;
    String error = "";
    String success = "";

    @GetMapping("/register")
    private String register(Model model) {
        model.addAttribute("error", error);
        model.addAttribute("success", success);
        error = "";
        success = "";
        Customer c = customerService.login("", "");
        System.out.println(c);
        return "register";
    }

    @PostMapping("/registerCustomer")
    public String customerRegister(Customer customer) {
        Customer c = customerService.save(customer);
        if (c != null && c.getCid() == null) {
            error = customer.getEmail() + ": mail already register!";
        } else if (c != null && c.getCid() > 0) {
            success = customer.getEmail() + ": registration was successful.";
        }
        return "redirect:/";
    }
}
