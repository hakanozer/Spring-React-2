package com.work.repositories;

import com.work.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByAidEquals(Long aid);
    Optional<Admin> findByUsernameEqualsIgnoreCaseAndPasswordEquals(String username, String password);
}