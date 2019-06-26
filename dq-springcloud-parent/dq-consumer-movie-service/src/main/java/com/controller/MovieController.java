package com.controller;

import com.feign.UserFeign;
import com.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/movie")
@Api(value = "movie")
public class MovieController {


    @Autowired
    private UserFeign userFeign;

    @GetMapping("/user/{id}")
    @ApiOperation(value = "通过用户信息", notes = "根据参数id查找用户信息")
    public User findById(@PathVariable Long id){
        return userFeign.findById(id);
    }

//    @Value("user.userServiceUrl")
//    private String userServiceUrl;
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @GetMapping("/user/{id}")
//    public User findById(@PathVariable Long id){
//        return this.restTemplate.getForObject(userServiceUrl + "user/" + id, User.class);
//    }
//
//    @GetMapping("/hello")
//    public String hello(){
//        return this.restTemplate.getForObject("http://192.168.255.1:8080/hello", String.class);
//    }

}
