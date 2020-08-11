package com.daxue.learnaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class LearnAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnAopApplication.class, args);
    }


}
