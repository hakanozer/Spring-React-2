package com.works.controllers;

import com.works.entities.Customer;
import com.works.services.CustomerService;
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

    @GetMapping("/")
    private String register(Model model){
        model.addAttribute("error", error);
        model.addAttribute("success", success);
        error = "";
        success = "";
        Customer c = customerService.login("ali@mail.com", "1234");
        System.out.println(c);
        return "register";
    }

    @PostMapping("/register")
    public String customerRegister(Customer customer) {
       Customer c = customerService.save(customer);
       if ( c != null && c.getCid() == null ) {
           error = customer.getEmail() + ": mail adresi daha önce kayıtlı!";
       }else if (c != null && c.getCid() > 0) {
           success = customer.getEmail() + ": Kayıt işlemi başarılı!";
       }
       return "redirect:/";
    }

}

