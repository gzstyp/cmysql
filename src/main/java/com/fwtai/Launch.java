package com.fwtai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.core.env.Environment;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
public class Launch{

    @Autowired
    private Environment env;

    public static void main(String[] args){
        SpringApplication.run(Launch.class,args);
    }
}