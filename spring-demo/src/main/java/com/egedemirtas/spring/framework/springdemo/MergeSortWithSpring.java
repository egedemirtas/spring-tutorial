package com.egedemirtas.spring.framework.springdemo;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class MergeSortWithSpring implements SortAlgo {
    public List<Integer> sort(List<Integer> numberList) {
        // sort numberList
        numberList.sort(Comparator.naturalOrder()); // assume this is doing merge sort
        return numberList;
    }
}
