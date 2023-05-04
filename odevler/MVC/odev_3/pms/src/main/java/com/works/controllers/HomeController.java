package com.works.controllers;

import com.works.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        ProductService services=new ProductService();
        model.addAttribute("products",services.products());
        return "home";
    }

}
