package com.egedemirtas.spring.framework.springdemo.basic.spring;

import com.egedemirtas.spring.framework.springdemo.basic.SortAlgo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BinarySearchWithSpring {
    @Autowired
    private SortAlgo sortAlgo;
    /***
     *      merge and quick sort are both dependencies, thus one of them is annotated with @Primary by choice, for spring to instantiate
     *      alternative approach is to use variable name for autowiring.
     *      If you use: private SortAlgo quickSortWithSpring; -->QuickSortWithSpring class will be autowired
     *      @Primary has higher priority then autowiring with name
     *
     */
    // you can also use @Qualifier("...") to chose from beans, if you have multiple beans to autowire
    @Autowired
    @Qualifier("merge")
    private SortAlgo sortAlgoQualified;


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
