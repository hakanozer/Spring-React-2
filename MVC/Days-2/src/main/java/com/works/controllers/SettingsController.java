package com.works.controllers;

import com.works.props.User;
import com.works.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SettingsController {

    @GetMapping("/settings")
    public String settings() {
        return "settings";
    }

    @PostMapping("/userSave")
    public String userSave(User user) {
        UserService service = new UserService();
        int status = service.userSave(user);
        if ( status > 0 )
            return "redirect:/";
        return "settings";
    }

}
