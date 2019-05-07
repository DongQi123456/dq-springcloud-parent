package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Value("user.userServiceUrl")
    private String userServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        return this.restTemplate.getForObject(userServiceUrl + "user/" + id, User.class);
    }

    @GetMapping("/hello")
    public String hello(){
        return this.restTemplate.getForObject("http://192.168.255.1:8080/hello", String.class);
    }

}
