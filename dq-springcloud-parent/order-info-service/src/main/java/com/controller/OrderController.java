package com.controller;

import com.po.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("/order/{id}")
    public String findOrderById(@PathVariable String id){
        Order order = new Order();
        order.setId(id);
        order.setPrice(23.5);
        order.setReceiverAddress("beijinh");
        order.setReceiverName("xiaoqiang");
        order.setReceiverPhone("13422343311");
        return order.toString();
    }


}
