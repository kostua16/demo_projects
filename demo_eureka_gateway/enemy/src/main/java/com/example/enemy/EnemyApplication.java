package com.example.enemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EnemyApplication {
    public static void main(String[] args) {
        SpringApplication.run(EnemyApplication.class);
    }
}
