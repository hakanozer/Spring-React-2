package com.works.jpa.repositories;

import com.works.jpa.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //select * from customer where email=? , password =?
    Optional<Customer> findByEmailEqualsIgnoreCaseAndPasswordEquals(String email, String password);

    Optional<Customer> findByCidEquals(Long cid);

    Optional<Customer> findByEmailEqualsIgnoreCase(String email);

}