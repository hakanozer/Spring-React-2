package com.example.jpa.config;

import com.example.jpa.entities.Customer;
import com.example.jpa.service.CustomerService;
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
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        String[] freeUrls = {"/", "/userLogin", "/register", "/registerCustomer"};
        boolean loginStatus = true;
        for (String item : freeUrls) {
            if (freeUrls.equals(item)) {
                loginStatus = false;
                break;
            }
        }
        if(loginStatus){
            boolean status = request.getSession().getAttribute("customer") == null;
            if(status){
                response.sendRedirect("/");
            }else{
                Customer customer = (Customer) request.getSession().getAttribute("customer");
                request.setAttribute("customer",customer);
                filterChain.doFilter(request,response);
            }
        }
        else {
            filterChain.doFilter(request,response);
        }
    }

}

