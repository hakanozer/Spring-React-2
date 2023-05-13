package com.works.jpa.controllers;

import com.works.jpa.entities.Product;
import com.works.jpa.repositories.ProductRepository;
import com.works.jpa.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DashboardController {

    final ProductService productService;

    @GetMapping("/dashboard")
    public String dashboard(Model model, Product product){
        model.addAttribute("products", productService.allProduct(product));

        return "dashboard";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(Product product){
        productService.save(product);
        return "redirect:/dashboard";
    }

    @GetMapping("/deleteProduct/{stPid}")
    public String deleteProduct(@PathVariable String stPid){
        boolean status = productService.deleteProduct(stPid);
        System.err.println("Status: " +status);
        return "redirect:/dashboard";
    }


}
