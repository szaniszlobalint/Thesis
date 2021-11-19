package com.redmine.application;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        SpringApplication.run(MyApplication.class, args);
    }
}