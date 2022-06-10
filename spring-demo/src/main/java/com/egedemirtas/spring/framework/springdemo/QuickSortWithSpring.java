package com.egedemirtas.spring.framework.springdemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
@Primary // there are 2 components that are autowired. Using this will prioritize this class
public class QuickSortWithSpring implements SortAlgo{
    public List<Integer> sort(List<Integer> numberList) {
        // sort numberList
        numberList.sort(Comparator.naturalOrder()); // assume this is doing bubble sort
        return numberList;
    }
}
