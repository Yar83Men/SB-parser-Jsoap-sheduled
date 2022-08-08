package com.jnews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SoapParserNewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapParserNewsApplication.class, args);
    }

}
