package com.works.services;

import com.works.models.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class AdminService {

    final HttpServletRequest req;

    public boolean login(Admin admin) {
        if ( admin.getEmail().equals("ali@mail.com") && admin.getPassword().equals("12345") ) {
            req.getSession().setAttribute("user", admin.getEmail());
            return true;
        }
        return false;
    }

}
