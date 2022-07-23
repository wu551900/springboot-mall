package com.youngwu.springbootmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SpringbootMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMallApplication.class, args);
    }

}
