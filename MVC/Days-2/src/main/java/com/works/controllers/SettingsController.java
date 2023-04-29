package com.works.controllers;

import com.works.props.User;
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
        System.out.println( user );
        return "settings";
    }

}
