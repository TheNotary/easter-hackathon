package com.njax.destructocats.java.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// @SpringBootApplication // (scanBasePackages={"com.njax.destructocats.java.app.models"})
@SpringBootApplication
// @ComponentScan(basePackages = {"com.njax.destructocats.java.app.models.version", "com.njax.destructocats.java.webapp"})
@EntityScan("com.njax.destructocats.java.app.models")
@EnableJpaRepositories("com.njax.destructocats.java.app.models")
public class Main {

    public static void main(String[] args) {
        System.out.println( "Booting spring app..." );

        SpringApplication.run(Main.class, args);
    }

}
