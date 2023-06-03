package com.work.service;

import com.work.entities.Admin;
import com.work.repositories.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {

    final AdminRepository adminRepository;
    final HttpServletResponse response;
    final HttpServletRequest request;


    public Admin login (String username, String password){
        try {
            Optional<Admin> optionalAdmin = adminRepository.findByUsernameEqualsIgnoreCaseAndPasswordEquals(username,password);
            if(optionalAdmin.isPresent()){
                return optionalAdmin.get();
            }
        }catch (Exception exception){
            System.err.println(exception);
        }
        return null;
    }
    public Admin registerAdmin(Admin admin){
        try {
            return adminRepository.save(admin);
        }catch (DataIntegrityViolationException e){
            System.err.println("username duplicate : "+e);
            return admin;
        }
        catch (Exception ex){
            return null;
        }
    }

    public String userAdmin(){
        try {
            Admin admin = (Admin) request.getSession().getAttribute("admin");
            String username =  admin.getUsername();
            return username;

        }catch (Exception exception){
            return null;
        }
    }
}
