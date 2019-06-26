package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

/**
 * 队列消息控制器
 */
@RestController
public class QueueController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    /**
     * 消息生成者
     */
    @GetMapping("/send")
    public void send(){
        //指定消息发送的目的地及内容
        jmsMessagingTemplate.convertAndSend(queue, "新发送的消息！");
    }

}
