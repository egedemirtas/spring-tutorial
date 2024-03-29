package com.egedemirtas.spring.framework.springdemo.basic;

import java.util.Comparator;
import java.util.List;

public class MergeSort implements SortAlgo {
    public List<Integer> sort(List<Integer> numberList) {
        // sort numberList
        numberList.sort(Comparator.naturalOrder()); // assume this is doing merge sort
        return numberList;
    }
}
