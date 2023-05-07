package com.works.repositories;

import com.works.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // select * from customer where email = ? and password  = ?
    Optional<Customer> findByEmailEqualsIgnoreCaseAndPasswordEquals(String email, String password);

}