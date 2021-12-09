package com.codeslogan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.codeslogan.mapper")
public class HnucisysApplication {
    public static void main(String[] args) {
        SpringApplication.run(HnucisysApplication.class, args);
    }

}
