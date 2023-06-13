package com.works.jpawork.controllers;

import com.works.jpawork.entities.User;
import com.works.jpawork.services.TinkEncDec;
import com.works.jpawork.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.crypto.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Controller
@RequiredArgsConstructor
public class LoginController {

    final TinkEncDec tinkEncDec;
    final UserService service;
    final HttpServletRequest request;
    final HttpServletResponse response;

    @GetMapping("/")
    public String login(){
        return "login";
    }

    @PostMapping("/loginUser")
    public String userLogin(User user) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
       User u = service.userLogin(user);
       if(u != null) {
           request.getSession().setAttribute("user", u);
           if(user.getRemember() != null && user.getRemember().equals("on")){
               String chipherText = tinkEncDec.encrypt(""+u.getUid());
               Cookie cookie = new Cookie("user",chipherText);
               cookie.setMaxAge(60 * 60);
               response.addCookie(cookie);
           }
           return "redirect:/product";
       }else{
           return "redirect:/";
       }
    }

    @GetMapping("/logout")
    public String logout(){
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("user","");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }
}
