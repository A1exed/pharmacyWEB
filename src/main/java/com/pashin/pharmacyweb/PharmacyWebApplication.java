package com.pashin.pharmacyweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class PharmacyWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PharmacyWebApplication.class, args);
    }

}
