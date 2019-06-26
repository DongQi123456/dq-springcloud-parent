package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShiroServiceApplication {

    public static void main(String[] args){
        SpringApplication.run(ShiroServiceApplication.class, args);
    }

}
