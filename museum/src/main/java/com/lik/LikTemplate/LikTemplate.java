package com.lik.LikTemplate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lik.LikTemplate.mapper")
@SpringBootApplication
public class LikTemplate {

    public static void main(String[] args) {
        SpringApplication.run(LikTemplate.class, args);
    }

}
