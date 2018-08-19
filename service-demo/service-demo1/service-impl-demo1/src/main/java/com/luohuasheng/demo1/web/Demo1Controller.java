package com.luohuasheng.demo1.web;

import com.luohuasheng.demo1.facade.Demo1Facade;
import com.luohuasheng.demo2.facade.Demo2Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author panda
 */
@RestController
public class Demo1Controller implements Demo1Facade {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

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

    @RequestMapping(value = "/sub2", method = RequestMethod.GET)
    public String sub2(@RequestParam Integer a, @RequestParam Integer b) {
        this.loadBalancerClient.choose("service-demo2");
        return restTemplate.getForEntity("http://service-demo2/sub?a=" + a + "&b=" + b, String.class).getBody();

    }

}