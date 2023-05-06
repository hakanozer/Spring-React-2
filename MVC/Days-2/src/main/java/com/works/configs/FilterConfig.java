package com.works.configs;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class FilterConfig implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String url = req.getRequestURI();
        String freeUrls[] = {"/", "/userLogin"};
        boolean loginStatus = true;
        for( String item : freeUrls ) {
            if(url.equals(item)) {
                loginStatus = false;
                break;
            }
        }

        if (loginStatus) {
            // session control
            boolean status = req.getSession().getAttribute("user") == null;
            if( status ) {
                // redirect Login
                res.sendRedirect("/");
            }else {
                chain.doFilter(req, res);
            }
        }else {
            chain.doFilter(req, res);
        }


    }

}
