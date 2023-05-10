package com.works.jpa.controllers;

import com.works.jpa.entities.Customer;
import com.works.jpa.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
     final CustomerService customerService;
     String error = "";
     String success = "";

    @GetMapping("/")
    public String login(Model model){
        model.addAttribute("error", error);
        model.addAttribute("success", success);
        error = "";
        success = "";
        return "login";
    }

    @PostMapping("/loginUser")
    public String loginUser(Customer customer){
      Customer c = customerService.login(customer.getEmail(),customer.getPassword());
      if(c== null){
          Customer control = customerService.loginCustomer(customer.getEmail());
          if(control == null){
              error = "Wrong Mail!";
              return "redirect:/";
          }else {
              error = "Wrong Password!";
              return "redirect:/";
          }
      }
      return "redirect:/dashboard";
    }



}
