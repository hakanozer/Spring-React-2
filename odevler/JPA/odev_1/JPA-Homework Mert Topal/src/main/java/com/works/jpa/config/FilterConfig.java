package com.works.jpa.config;


import com.works.jpa.entities.Customer;
import com.works.jpa.service.CustomerService;
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
    final CustomerService customerService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String url = req.getRequestURI();
        String freeUrls[] = {"/","/loginUser","/register","/registerCustomer"};

        boolean loginStatus = true;
        for(String item : freeUrls){
           if(url.equals(item)){
               loginStatus = false;
               break;
           }
        }
        if(loginStatus){
            boolean status = req.getSession().getAttribute("customer") == null;
            if(status){
                res.sendRedirect("/dashboard");
            }else{
                Customer customer = (Customer) req.getSession().getAttribute("customer");
                System.out.println("this line user "+ customer);
                req.setAttribute("customer",customer);
                filterChain.doFilter(req,res);
            }

        }
        else {
            filterChain.doFilter(req,res);
        }

    }
}
