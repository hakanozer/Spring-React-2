package com.example.jpa.repositories;

import com.example.jpa.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //select * from customer where email = ? and password = ?
    Optional<Customer> findByEmailEqualsIgnoreCaseAndPasswordEquals(String email, String password);

    Optional<Customer> findByEmailEqualsIgnoreCase(String email);

    Optional<Customer> findByCidEquals(Long cid);




}