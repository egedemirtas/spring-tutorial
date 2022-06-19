package com.egedemirtas.spring.framework.springdemo.basic;

import java.util.List;

public class BinarySearch {
    private final SortAlgo sortAlgo;

    public BinarySearch(SortAlgo sortAlgo) {
        this.sortAlgo = sortAlgo;
    }

    public Integer binarySearch(List<Integer> numberList, Integer search) {
        if (search == null || numberList == null || this.sortAlgo == null) {
            return -1;
        }
        // first sort array
        List<Integer> sortedNumList = this.sortAlgo.sort(numberList);
        // search in sorted array

        return 0;
    }
}
