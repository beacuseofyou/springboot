package com;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfig //开启dubbo的自动配置
public class SpringbootDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboProviderApplication.class, args);
    }
}
