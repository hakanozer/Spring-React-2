package com.works.jpawork.repositories;

import com.works.jpawork.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
 User  findByEmailEqualsAndPasswordEquals(String email,String password);

 User findByUid(Long uid);


}