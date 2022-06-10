package com.egedemirtas.spring.framework.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SpringDemoApplication {

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
        ApplicationContext appContext = SpringApplication.run(SpringDemoApplication.class, args);
        BinarySearchWithSpring binarySearchWithSpring = appContext.getBean(BinarySearchWithSpring.class);
        Integer indexWithSpring = binarySearchWithSpring.binarySearch(Arrays.asList(16, 3, 7, 8), 3);
        System.out.println("-------------Index with Spring:"+ indexWithSpring);
    }

}
