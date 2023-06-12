package com.works.jpawork.services;

import com.works.jpawork.entities.User;
import com.works.jpawork.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    final UserRepository userRepository;

    final TinkEncDec tinkEncDec;

    public User userLogin(User user){
        try{
            List<User> users = userRepository.findAll();
            for (User u : users) {
                String plainText = tinkEncDec.decrypt(u.getPassword());
                if(plainText.equals(user.getPassword()) && user.getEmail().equals(u.getEmail())){
                    return u;
                }
            }
        }catch (Exception ex){
            System.err.println("login error: "+ex);
        }
        return null;
    }

    public User save(User user){
        user.setStatus(true);
        try{
            return userRepository.save(user);
        }catch (DataIntegrityViolationException ex){
            System.err.println(ex.getMessage());
            return user;
        }catch (Exception sql){
            System.err.println(sql.getMessage());
            return null;
        }
    }

    public User single(long id){
        try{
            User user = userRepository.findByUid(id);
            if(user != null){
                return user;
            }
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }
        return null;
    }

}
