package com.works.controllers;

import com.works.props.User;
import com.works.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    UserService service = new UserService();
    int status = -1;
    String message = "";
    int uid = 0;

    @GetMapping("/home")
    public String home(Model model, @RequestParam(defaultValue = "1") int p) {
        model.addAttribute("users", service.users(p));
        model.addAttribute("status", status);
        model.addAttribute("message", message);
        model.addAttribute("uid", uid);
        int count = service.totalCount();
        model.addAttribute("count", count);
        int page = count % 50 == 0 ? count / 50 : (count / 50) + 1;
        model.addAttribute("page", page);
        model.addAttribute("p", p);

        status = -1;
        message = "";
        uid = 0;
        return "home";
    }

    @GetMapping("/userInfo/{uid}")
    public String userInfo(@PathVariable int uid, Model model) {
        User u = service.single(uid);
        model.addAttribute("user", u);
        return "userInfo";
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
        return "redirect:/home";
    }


    @GetMapping("/userBack/{uid}")
    public String userBack(@PathVariable int uid) {
        service.deleteUser(uid, 1);
        return "redirect:/home";
    }

    @PostMapping("/userUpdate")
    public String userUpdate( User user ) {
        System.out.println(user);
        service.updateUser(user);
        return "redirect:/home";
    }


}
