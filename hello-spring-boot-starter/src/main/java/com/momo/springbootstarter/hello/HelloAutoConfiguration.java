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
// 启用对指定带@ConfigurationProperties注解的bean的支持
@EnableConfigurationProperties(value = HelloProperties.class)
// classpath路径下存在HelloHandler类则配置
@ConditionalOnClass(HelloHandler.class)
// 配置文件hello.enable=true则配置，如果没有该属性则默认设置为true
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
