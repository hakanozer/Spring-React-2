package com.works.controllers;

import com.works.props.User;
import com.works.services.TinkEncDec;
import com.works.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
public class LoginController {

    final TinkEncDec tinkEncDec;

    UserService userService = new UserService();
    final HttpServletRequest request;
    final HttpServletResponse response;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/userLogin")
    public String userLogin(User user) {
        User u = userService.loginUser(user);
        if (u != null) {
            request.getSession().setAttribute("user", u);
            if ( user.getRemember() != null && user.getRemember().equals("on") ) {
                String cipherText = tinkEncDec.encrypt(""+u.getUid());
                Cookie cookie = new Cookie("user", cipherText);
                cookie.setMaxAge(60 * 60);
                response.addCookie(cookie);
            }
            return "redirect:/home";
        }
        return "redirect:/";
    }


    @GetMapping("/logout")
    public String logout() {
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("user", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }

}
