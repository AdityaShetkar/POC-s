package com.reactivedb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveDbApplication.class, args);
        System.err.println("READY TO TEST..!");
    }

}
