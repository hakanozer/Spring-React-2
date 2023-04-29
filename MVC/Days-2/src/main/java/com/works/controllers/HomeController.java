package com.works.controllers;

import com.works.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    UserService service = new UserService();
    int status = -1;
    String message = "";
    int uid = 0;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("users", service.users());
        model.addAttribute("status", status);
        model.addAttribute("message", message);
        model.addAttribute("uid", uid);
        status = -1;
        message = "";
        uid = 0;
        return "home";
    }

    @GetMapping("/userDelete/{uid}")
    public String userDelete(@PathVariable int uid) {
        status = service.deleteUser(uid, 0);
        if (status > 0) {
            message = "Delete Success - " + uid;
            this.uid = uid;
        }else {
            message = "Delete Fail - " + uid;
        }
        return "redirect:/";
    }


    @GetMapping("/userBack/{uid}")
    public String userBack(@PathVariable int uid) {
        service.deleteUser(uid, 1);
        return "redirect:/";
    }


}
