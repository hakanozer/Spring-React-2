package com.works.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class JpaConfig implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String email = "ali@mail.com";
        Optional<String> optional = Optional.of(email);
        return optional;
    }

}
