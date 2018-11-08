package com.momo.springbootstarter.hello;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: MQG
 * @date: 2018/11/8
 */
@ConfigurationProperties(prefix = "hello")
public class HelloProperties {
    
    private boolean enable;
    
    private String msg = "";

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
