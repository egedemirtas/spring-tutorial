package com.egedemirtas.spring.framework.springdemo.componentscan.app;

import com.egedemirtas.spring.framework.springdemo.componentscan.ComponentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication // automatically scans com.egedemirtas.spring.framework.springdemo.componentscan.app and subdirectories, thus this app won't run without @ComponentScan
@ComponentScan("com.egedemirtas.spring.framework.springdemo.componentscan")
public class ComponentScanDemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(ComponentScanDemoApplication.class);

    public static void main(String[] args) {
        ApplicationContext appContext = SpringApplication.run(ComponentScanDemoApplication.class, args);
        ComponentDAO componentDao = appContext.getBean(ComponentDAO.class);

        logger.info("{}", componentDao);
    }
}
