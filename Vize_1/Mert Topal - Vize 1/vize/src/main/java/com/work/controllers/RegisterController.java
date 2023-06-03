package com.work.controllers;

import com.work.entities.Admin;
import com.work.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegisterController {
    final AdminService adminService;
    String error = "";
    String success = "";

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("error", error);
        model.addAttribute("success",success);

        error = "";
        success = "";

        return "registerAdmin";
    }

    @PostMapping("/registerAdmin")
    public String registerAdmin(Admin admin){
        Admin a = adminService.registerAdmin(admin);
        if(admin != null && a.getAid() == null ){
            error = admin.getUsername() + "This username or email has been used before.";
        } else if (admin != null && a.getAid()>0) {
            success = admin.getUsername() +"Registration successful.";
        }
        return "redirect:/";
    }
}
