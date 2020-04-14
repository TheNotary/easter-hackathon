package com.njax.destructocats.java.app.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;


@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        System.out.println( "Booting spring app..." );

        SpringApplication.run(Main.class, args);
    }

}
