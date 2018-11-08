package com.momo.springbootstarter.hellospringbootstartertest.controller;

import com.momo.springbootstarter.hello.HelloHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: MQG
 * @date: 2018/11/8
 */
@RestController
public class HelloController {
    
    @Autowired
    private HelloHandler helloHandler;
    
    @GetMapping("/sayHello")
    public String sayHello() {
        return helloHandler.sayHello();
    }
}
