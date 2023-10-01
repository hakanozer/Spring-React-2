package com.works.restcontrollers;

import com.works.entities.Customer;
import com.works.models.JWTLogin;
import com.works.services.CustomerService;
import com.works.services.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerRestcontroller {

    final CustomerService customerService;
    final JWTService jwtService;

    @PostMapping("/register")
    public Customer register(@RequestBody Customer customer) {
        return customerService.register(customer);
    }

    @PostMapping("/auth")
    public ResponseEntity auth(@RequestBody JWTLogin jwtLogin) {
        return jwtService.auth(jwtLogin);
    }

}