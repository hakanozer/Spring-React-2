package com.works.services;


import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;
    final PasswordEncoder passwordEncoder;

    public void register(Customer customer) {
        String newPassword = passwordEncoder.encode(customer.getPassword());
    }


}
