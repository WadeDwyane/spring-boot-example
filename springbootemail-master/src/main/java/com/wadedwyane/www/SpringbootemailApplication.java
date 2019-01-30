package com.wadedwyane.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
public class SpringbootemailApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootemailApplication.class, args);
    }
}

