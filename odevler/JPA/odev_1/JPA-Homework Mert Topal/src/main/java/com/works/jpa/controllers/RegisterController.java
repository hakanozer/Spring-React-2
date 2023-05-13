package com.works.jpa.controllers;

import com.works.jpa.entities.Customer;
import com.works.jpa.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegisterController {
    final CustomerService customerService;
    String error = "";
    String success = "";

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("error", error);
        model.addAttribute("success",success);
        error = "";
        success = "";
        Customer c = customerService.login("","");
        System.out.println(c);
        return "register";
    }

    @PostMapping("/registerCustomer")
    public String customerRegister(Customer customer){
        Customer c = customerService.save(customer);
        if( customer != null && c.getCid()== null){
            error = customer.getEmail() + " This email has been used before.";

        }else if (customer != null && c.getCid()> 0) {
            success = customer.getEmail()+ "Registration successful.";
        }

        return "redirect:/";
    }

}
