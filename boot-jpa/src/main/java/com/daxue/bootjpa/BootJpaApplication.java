package com.daxue.bootjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.daxue.bootjpa.dao")
@EntityScan(basePackages = "com.daxue.bootjpa.pojo")
public class BootJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootJpaApplication.class, args);
    }

}
