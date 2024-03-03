package org.acme2.animalapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AnimalApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnimalApplication.class, args);
    }
}