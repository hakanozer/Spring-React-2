package com.works.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppBeans {

    @Bean
    public void autoCall() {
        System.out.println("This Line Call");
    }

}
