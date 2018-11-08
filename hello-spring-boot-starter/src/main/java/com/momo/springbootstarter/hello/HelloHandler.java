package com.momo.springbootstarter.hello;

/**
 * @author: MQG
 * @date: 2018/11/8
 */

public class HelloHandler {
    
    private String msg;
    
    public String sayHello() {
        return "Hello " + msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
