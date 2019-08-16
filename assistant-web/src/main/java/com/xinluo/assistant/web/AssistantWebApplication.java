package com.xinluo.assistant.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.xinluo.assistant")
@MapperScan(basePackages = "com.xinluo.assistant.jpa.*")
public class AssistantWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssistantWebApplication.class, args);
    }

}
