package com.egedemirtas.spring.framework.springdemo.basic.spring;

import com.egedemirtas.spring.framework.springdemo.basic.SortAlgo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Comparator;
import java.util.List;

@Service
@Qualifier("merge")
public class MergeSortWithSpring implements SortAlgo {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public List<Integer> sort(List<Integer> numberList) {
        // sort numberList
        numberList.sort(Comparator.naturalOrder()); // assume this is doing merge sort
        return numberList;
    }

    @PostConstruct
    // as soon as bean is created and dependencies initialized this method will be called, thus you can perform actions that require autowired dependencies
    public void postConstruct(){
        logger.info("post construct");
    }

    @PreDestroy // just before destroying the bean and dependencies, this won't be called if your bean is prototype, you have to manually shutdown the application with code in main()
    public void preDestroy(){
        logger.info("pre destroy");
    }
}
