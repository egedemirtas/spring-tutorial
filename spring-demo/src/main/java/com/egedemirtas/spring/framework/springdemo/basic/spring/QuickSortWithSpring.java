package com.egedemirtas.spring.framework.springdemo.basic.spring;

import com.egedemirtas.spring.framework.springdemo.basic.SortAlgo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@Primary // there are 2 components that are autowired. Using this will prioritize this class
@Qualifier("quick")
public class QuickSortWithSpring implements SortAlgo {
    public List<Integer> sort(List<Integer> numberList) {
        // sort numberList
        numberList.sort(Comparator.naturalOrder()); // assume this is doing bubble sort
        return numberList;
    }
}
