package com.works.jpawork.configs;

import com.works.jpawork.entities.User;
import com.works.jpawork.services.TinkEncDec;
import com.works.jpawork.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class FilterConfig implements Filter {
    final UserService service;
    final TinkEncDec tinkEncDec;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURI();
        String freeUrls[] = {"/","/register","/userSave","/loginUser"};
        boolean loginStatus = true;
        for(String item : freeUrls){
            if(url.equals(item)){
                loginStatus = false;
                break;
            }
        }
        if(loginStatus){
            if(request.getCookies() != null){
                Cookie[] cookies = request.getCookies();
                for(Cookie cookie : cookies){
                    if(cookie.getName().equals("user")){
                        String plainText = tinkEncDec.decrypt(cookie.getValue());
                        long val = Long.parseLong(plainText);
                       User u = service.single(val);
                        if(u != null){
                            request.getSession().setAttribute("user",u);
                            break;
                        }
                    }
                }
            }
            // session control
            boolean status = request.getSession().getAttribute("user") == null;
            if(status){
                response.sendRedirect("/");
            }else{
                User user  = (User) request.getSession().getAttribute("user");
                request.setAttribute("user",user);
                filterChain.doFilter(request,response);
            }
        }else{
            filterChain.doFilter(request,response);
        }
    }
}
