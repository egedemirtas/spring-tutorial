package com.egedemirtas.spring.framework.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BinarySearchWithSpring {
    @Autowired
    private SortAlgo sortAlgo;

    //spring uses constructor to do autowiring: Autowiring by type from bean name 'binarySearchWithSpring' via constructor to bean named 'quickSortWithSpring': this called constructor injection
//    public BinarySearchWithSpring(SortAlgo sortAlgo) {
//        this.sortAlgo = sortAlgo;
//    }

    // setter injection can be used as an alternative to constructor injection
//    public void setSortAlgo(SortAlgo sortAlgo) {
//        this.sortAlgo = sortAlgo;
//    }

    // OR you can just use none of them. For spring this is actually same as doing setter injection


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
