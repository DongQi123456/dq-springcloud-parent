package com;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import javax.jms.Queue;

@SpringBootApplication
@EnableCaching
@EnableEurekaClient
public class UserApplication {

    @Bean
    public Queue queue(){
        return new ActiveMQQueue("active.queue");
    }

    public static void main(String[] args){
        SpringApplication.run(UserApplication.class, args);
    }

}
