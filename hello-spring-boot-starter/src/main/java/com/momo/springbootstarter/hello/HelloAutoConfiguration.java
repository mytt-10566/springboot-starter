package com.momo.springbootstarter.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: MQG
 * @date: 2018/11/8
 */
@Configuration
@EnableConfigurationProperties(value = HelloProperties.class)
@ConditionalOnClass(HelloHandler.class)
// 只有我们的配置文件是否配置了以hello为前缀的资源项值，并且在该资源项值为enable，如果没有配置我们默认设置为true
@ConditionalOnProperty(prefix = "hello", name = "enable", matchIfMissing = true)
public class HelloAutoConfiguration {
    
    @Autowired
    private HelloProperties helloProperties;
    
    @Bean
    @ConditionalOnMissingBean(HelloHandler.class)
    public HelloHandler helloHandler() {
        HelloHandler helloHandler = new HelloHandler();
        helloHandler.setMsg(helloProperties.getMsg());
        return helloHandler;
    }
}
