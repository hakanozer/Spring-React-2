package com.works.jpawork.controllers;

import com.works.jpawork.entities.Product;
import com.works.jpawork.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class SearchController {
    final ProductService productService;

    @GetMapping("/search")
    public String searchProduct(String q, Model model){
     Product prd = productService.searchProduct(q);
     model.addAttribute("product",prd);
        return "searchProduct";
    }
}
