package com.works.controllers;

import com.works.props.Address;
import com.works.props.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Site Title");
        model.addAttribute("user", singleUser());
        model.addAttribute("users", users());
        return "home";
    }


    private User singleUser() {
        User u = new User();
        u.setUid(100);
        u.setName("Erkan");
        u.setSurname("Bilsin");

        Address address = new Address();
        address.setAid(10);
        address.setDetail("Beşiktaş / İstanbul / Türkiye");
        u.setAddress(address);
        return u;
    }

    private List<User> users() {
        List<User> ls = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User u = new User();
            u.setUid(new Random().nextInt(1000));
            u.setName("Name - " + i);
            u.setSurname("Surname - " + i);

            Address address = new Address();
            address.setAid(new Random().nextInt(1000));
            address.setDetail("Beşiktaş / İstanbul / Türkiye");
            u.setAddress(address);
            ls.add(u);
        }
        return ls;
    }

}
