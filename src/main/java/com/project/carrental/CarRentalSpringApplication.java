package com.project.carrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class CarRentalSpringApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CarRentalSpringApplication.class, args);
    }
}