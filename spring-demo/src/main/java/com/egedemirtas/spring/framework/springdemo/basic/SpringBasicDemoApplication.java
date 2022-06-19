package com.egedemirtas.spring.framework.springdemo.basic;

import com.egedemirtas.spring.framework.springdemo.basic.spring.BinarySearchWithSpring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SpringBasicDemoApplication {

    public static void main(String[] args) {
        // loosely coupled, dependency injection without IOC
        SortAlgo sortAlgo = new MergeSort();
        BinarySearch binarySearch = new BinarySearch(sortAlgo);
        Integer index = binarySearch.binarySearch(Arrays.asList(16, 3, 7, 8), 3);
        System.out.println("-------------Index without Spring:"+ index);

        //what are the beans
        //what are the dependencies of beans
        //where are beans: there is @SpringBootApplication annotation in this main app class. It automatically searches for beans in this package/and sub-packages
        //Application Context manages all the beans
        ApplicationContext appContext = SpringApplication.run(SpringBasicDemoApplication.class, args);
        BinarySearchWithSpring binarySearchWithSpring = appContext.getBean(BinarySearchWithSpring.class);
        Integer indexWithSpring = binarySearchWithSpring.binarySearch(Arrays.asList(16, 3, 7, 8), 3);
        System.out.println("-------------Index with Spring:"+ indexWithSpring);

        // this actually refers to the same bean as binarySearchWithSpring, since beans are singleton by default. You will that both of them refers to the same hashcode
        // BinarySearchWithSpring binarySearchWithSpring1 = appContext.getBean(BinarySearchWithSpring.class);
        // add @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) to BinarySearchWithSpring to get different instances when you are getting the same bean from app context
        BinarySearchWithSpring binarySearchWithSpring1 = appContext.getBean(BinarySearchWithSpring.class);
    }

}
