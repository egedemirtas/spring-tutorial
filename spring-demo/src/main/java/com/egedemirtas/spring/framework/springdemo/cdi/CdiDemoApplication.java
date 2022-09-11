package com.egedemirtas.spring.framework.springdemo.cdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CdiDemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(CdiDemoApplication.class);

    public static void main(String[] args) {
        ApplicationContext appContext = SpringApplication.run(CdiDemoApplication.class, args);

        CdiDao cdiDao = appContext.getBean(CdiDao.class);

        logger.info("{}", cdiDao);
    }

}
