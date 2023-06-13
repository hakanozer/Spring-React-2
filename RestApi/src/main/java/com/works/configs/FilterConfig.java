package com.works.configs;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class FilterConfig implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String ipAddress = req.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = req.getRemoteAddr();
        }

        // session control
        String freeUrl = "/admin/login";
        String url = req.getRequestURI();
        boolean loginStatus = true;
        if ( url.equals(freeUrl) ) {
            loginStatus = false;
        }

        if (loginStatus) {
            boolean status = req.getSession().getAttribute("user") == null;
            if (status) {
                // session null
                PrintWriter printWriter = res.getWriter();
                printWriter.println("{ \"status\": false, \"result\": \"Plase Login\" }");
                res.setContentType("application/json");
                res.setStatus(401);
            }else {
                // session true
                filterChain.doFilter(req, res);
            }
        }else {
            filterChain.doFilter(req, res);
        }

    }

}
