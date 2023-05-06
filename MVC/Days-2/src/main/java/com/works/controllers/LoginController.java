package com.works.controllers;

import com.works.props.User;
import com.works.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LoginController {

    UserService userService = new UserService();
    final HttpServletRequest request;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/userLogin")
    public String userLogin(User user) {
        User u = userService.loginUser(user);
        if (u != null) {
            request.getSession().setAttribute("user", u);
            return "redirect:/home";
        }
        return "redirect:/";
    }


    @GetMapping("/logout")
    public String logout() {
        request.getSession().removeAttribute("user");
        return "redirect:/";
    }

}
