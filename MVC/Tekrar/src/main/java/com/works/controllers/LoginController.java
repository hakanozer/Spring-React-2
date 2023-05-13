package com.works.controllers;

import com.works.entities.Customer;
import com.works.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LoginController {

    final CustomerService customerService;
    final HttpServletRequest request;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/loginUser")
    public String loginUser(Customer customer) {
        Customer c = customerService.login(customer);
        if ( c != null ) {
            // giriş başarılı
            request.getSession().setAttribute("user", c);
            return "redirect:/dashboard";
        }else {
            // giriş hatalı
        }
        System.out.println(customer);
        return "redirect:/";
    }

}
