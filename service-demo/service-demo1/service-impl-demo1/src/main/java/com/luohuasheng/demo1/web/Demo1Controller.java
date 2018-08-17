package com.luohuasheng.demo1.web;

import com.luohuasheng.demo1.facade.Demo1Facade;
import com.luohuasheng.demo2.facade.Demo2Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @author panda
 */
@RestController
public class Demo1Controller implements Demo1Facade {


    @Autowired
    private Demo2Facade demo2Facade;

    @Override
    public Integer add(Integer a, Integer b) {
        return a + b;
    }


    @Override
    public Integer sub(Integer a, Integer b) {
        return demo2Facade.sub(a, b);
    }


}