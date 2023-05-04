package com.works.product.controllers;


import com.works.product.props.Products;
import com.works.product.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    ProductService productService = new ProductService();

    @GetMapping("/")
    public String home(Model model){
        return "home";
    }

    @GetMapping("/products")
    public String products( Model model){

        model.addAttribute("products",productService.products());
        return "products";
    }

    @PostMapping("/saveProduct")
    public String userSave(Products products){

        int status = productService.saveProduct(products);
        if(status > 0){
            return "redirect:/";
        }
        return "home";
    }



}
