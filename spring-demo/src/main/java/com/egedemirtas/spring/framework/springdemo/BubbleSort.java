package com.egedemirtas.spring.framework.springdemo;

import java.util.Comparator;
import java.util.List;

public class BubbleSort implements SortAlgo {

    public List<Integer> sort(List<Integer> numberList) {
        // sort numberList
        numberList.sort(Comparator.naturalOrder()); // assume this is doing bubble sort
        return numberList;
    }

}
