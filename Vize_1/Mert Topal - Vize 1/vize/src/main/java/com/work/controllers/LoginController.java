package com.work.controllers;


import com.work.entities.Admin;
import com.work.service.AdminService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequiredArgsConstructor
public class LoginController {
    final AdminService adminService;
    final HttpServletRequest request;
    final HttpServletResponse response;
    String error = "";
    String success = "";

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("error", error);
        model.addAttribute("success", success);

        error = "";
        success = "";
        return "login";
    }

    @PostMapping("/loginAdmin")
    public String loginAdmin(Admin admin){
        Admin a = adminService.login(admin.getUsername(),admin.getPassword());
        if( a == null){
            error = "Wrong username or password!";
            return "redirect:/login";
        }
        else{
            request.getSession().setAttribute("admin",a);
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout(){
        request.getSession().removeAttribute("admin");
        return "redirect:/";
    }
}
