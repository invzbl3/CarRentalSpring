package com.project.carrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CarRentalSpringApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = "user";
        boolean isPasswordMatches = passwordEncoder.matches(password, "$2a$10$iBEWy3dsU/imowFjEeBfo./8NMVxgaqOLTYdTy8Rkr1z/KFb4v2EO");
        System.out.println(isPasswordMatches);
        SpringApplication.run(CarRentalSpringApplication.class, args);
    }

    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CarRentalSpringApplication.class);
    }*/
}