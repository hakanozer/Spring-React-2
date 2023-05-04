package com.works.controllers;

import com.works.props.Products;
import com.works.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    Products products=new Products();
    @GetMapping("/product")
    public String product(){
        return "product";
    }
    @PostMapping("/addProduct")
    public String addProduct(Products products){

        ProductService service=new ProductService();
        int status = service.addProduct(products);
        if (status >0){
            return "home";
        }
        return "product";
    }
}
