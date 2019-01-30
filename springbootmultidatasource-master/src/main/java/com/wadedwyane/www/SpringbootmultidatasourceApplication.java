package com.wadedwyane.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.wadedwyane.www")
public class SpringbootmultidatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootmultidatasourceApplication.class, args);
    }

}

