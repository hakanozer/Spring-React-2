package com.work.config;

import com.work.entities.Admin;
import com.work.repositories.ProductRepository;
import com.work.service.AdminService;
import com.work.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;


@Configuration
@RequiredArgsConstructor
public class Config implements Filter {
    final AdminService adminService;
    final ProductService productService;
    final ProductRepository productRepository;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String url = req.getRequestURI();

        String freeUrls[] = {"/","/register","/login","/loginAdmin","/registerAdmin","/detail/","/images"};
        Pattern freePattern = Pattern.compile("^/(detail|images).*");


        boolean loginStatus = true;
        for(String item : freeUrls){
            if (url.equals(freeUrls) || freePattern.matcher(url).matches()) {
                loginStatus = false;
            }
            if(url.equals(item)){
                loginStatus = false;
                break;
            }

        }
        if(loginStatus){
            boolean status = req.getSession().getAttribute("admin") == null;
            if(status){
                res.sendRedirect("/login");
            }else{
                Admin admin = (Admin) req.getSession().getAttribute("admin");
                System.out.println("this line user "+ admin);
                req.setAttribute("admin",admin);
                filterChain.doFilter(req,res);
            }
        }
        else {
            filterChain.doFilter(req,res);
        }
    }
}
