package com.egedemirtas.spring.framework.springdemo.properties;

import com.egedemirtas.spring.framework.springdemo.properties.external.service.DemoExternalService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class PropertiesApplication {
    public static void main(String[] args) {
        ApplicationContext appContext = SpringApplication.run(PropertiesApplication.class, args);
        DemoExternalService demoExternalService = appContext.getBean(DemoExternalService.class);
        System.out.println("\n-------------Url:" + demoExternalService.getUrl());
    }
}
