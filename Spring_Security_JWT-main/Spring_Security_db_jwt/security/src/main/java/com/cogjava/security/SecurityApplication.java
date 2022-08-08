package com.cogjava.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EntityScan("com.cogjava.*")
@EnableJpaRepositories("com.cogjava.*")
@EnableEurekaClient
@EnableWebSecurity

public class SecurityApplication {

    public static void main(String[] args) {

        SpringApplication.run(SecurityApplication.class, args);
    }

}

