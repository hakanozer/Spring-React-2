package com.works.jpawork.controllers;

import com.works.jpawork.entities.Product;
import com.works.jpawork.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    final ProductService service ;

    @GetMapping("/product")
    public String products(Model model){
        model.addAttribute("product",service.productList());

        return "product";
    }

    @GetMapping("/addProduct")
    public String addProduct(Product product){
        service.saveProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/deleteProduct/{pid}")
    public String deleteProduct(@PathVariable String pid){
        service.deleteProduct(pid);
        return "redirect:/product";
    }

    @GetMapping("/updateProduct")
    public String update(Product product){
        service.updateProduct(product);
        return "redirect:/product";
    }
}
