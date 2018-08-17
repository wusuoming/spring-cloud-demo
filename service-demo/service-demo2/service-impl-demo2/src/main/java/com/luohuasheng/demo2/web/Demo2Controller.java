package com.luohuasheng.demo2.web;

import com.luohuasheng.demo1.facade.Demo1Facade;
import com.luohuasheng.demo2.facade.Demo2Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author panda
 */
@RestController
public class Demo2Controller implements Demo2Facade {


    @Autowired
    private Demo1Facade demo1Facade;


    @Override
    public Integer sub(Integer a, Integer b) {
        return a - b;
    }

    @Override
    public Integer add(Integer a, Integer b) {
        return demo1Facade.add(a, b);

    }
}