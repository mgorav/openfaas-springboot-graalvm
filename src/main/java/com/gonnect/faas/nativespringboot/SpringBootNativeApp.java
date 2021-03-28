package com.gonnect.faas.nativespringboot;

import function.Handler;
import function.RequestHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootNativeApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootNativeApp.class, args);
    }

    @Bean
    RequestHandler handler() {
        return new Handler();
    }
}
