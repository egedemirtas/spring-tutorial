package com.egedemirtas.spring.framework.springdemo.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringScopeDemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringScopeDemoApplication.class);

    public static void main(String[] args) {
        ApplicationContext appContext = SpringApplication.run(SpringScopeDemoApplication.class, args);
        PersonDAO personDao1 = appContext.getBean(PersonDAO.class);
        PersonDAO personDao2 = appContext.getBean(PersonDAO.class);
        logger.info("{}", personDao1);
        logger.info("{}", personDao1.getJdbcConnection());

        logger.info("{}", personDao2);
        logger.info("{}", personDao2.getJdbcConnection());

        // personDao is singleton and jdbcConnection is prototype.
        // No surprise we get the same hash code for dao's since it is a singleton bean by default, however why do we get same hash codes for jdbc connections as well??
        // personDao doesn't realize that jdbcConnection is prototype
        // thus use @Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS) in personDao

        // when ever you get jdbc bean, a new instance will be created even if the personDao is the same!!!!
        logger.info("{}", personDao1.getJdbcConnection());
    }
}
