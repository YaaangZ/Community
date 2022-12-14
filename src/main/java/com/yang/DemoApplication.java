package com.yang;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * Git App
 * HomePage URL: http://community.yang
 * Authorization callback URL: http://localhost:8080/callback
 */

/**
 * 引导类
 */
@SpringBootApplication
@MapperScan("com.yang.mapper")
@EnableScheduling
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
