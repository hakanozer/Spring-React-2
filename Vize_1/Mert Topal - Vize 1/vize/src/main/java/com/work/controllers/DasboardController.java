package com.work.controllers;

import com.work.entities.Product;
import com.work.entities.ProductImage;
import com.work.service.AdminService;
import com.work.service.ImagesService;
import com.work.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class DasboardController {
    final ProductService productService;
    final AdminService adminService;


    @GetMapping("/")
    public String dashboard(Model model, @RequestParam(defaultValue = "0") int page,Product product){
       model.addAttribute("products", productService.allProduct(page));
       model.addAttribute("admin",adminService.userAdmin());
        return "dashboard";
    }

    @GetMapping("/adminPanel")
    public String adminPanel(Model model, @RequestParam(defaultValue = "0") int page){
        model.addAttribute("products", productService.adminProduct(page));
        model.addAttribute("admin",adminService.userAdmin());
        return "adminPanel";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(Product product){
        productService.save(product);
        return "redirect:/adminPanel";
    }

    @GetMapping("/deleteProduct/{stPid}")
    public String deleteProduct(@PathVariable String stPid){
        boolean status = productService.deleteProduct(stPid);
        System.err.println("Status: " +status);
        return "redirect:/adminPanel";
    }

}
