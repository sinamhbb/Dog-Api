package com.dog.example.bootstrap;

import com.dog.example.bootstrap.entity.CatFact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class BootstrapApplication {

    private static final Logger log = LoggerFactory.getLogger(BootstrapApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(BootstrapApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) {
        return args -> {
            CatFact catfact = restTemplate.getForObject(
                    "https://cat-fact.herokuapp.com/facts/random", CatFact.class);
            assert catfact != null;
            log.info(catfact.toString());
        };
    }
}
