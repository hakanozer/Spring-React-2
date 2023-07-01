package com.works.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebEndpoint;
import java.util.Random;

@Configuration
public class AppBeans {

    @Bean
    public Integer integer() {
        return new Integer(10);
    }

    @Bean
    public Random random( Integer integer ) {
        return new Random(integer);
    }

    @Bean(name = "rs1")
    public RestTemplate restTemplate_1( Random random ) {
        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.headForHeaders("apiKey","asd");
        return restTemplate;
    }

    @Bean(name = "rs2")
    public RestTemplate restTemplate_2( HttpServletRequest req ) {
        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.headForHeaders("apiKey","123");
        return restTemplate;
    }


}
