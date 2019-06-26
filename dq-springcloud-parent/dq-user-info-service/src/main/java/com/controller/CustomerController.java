package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户控制器
 */
@RestController
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    /**
     * 监听和读取消息
     * @param message
     */
    @JmsListener(destination = "active.queue")
    public void readActiveQueue(String message){
        logger.info("接收到：" + message);
    }

}
