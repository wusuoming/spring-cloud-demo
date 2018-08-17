package com.luohuasheng.demo1.facade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author panda
 */
@FeignClient(name = "service-demo1")
public interface Demo1Facade {

    @RequestMapping(value = "/sub", method = RequestMethod.GET)
    Integer sub(@RequestParam("a") Integer a, @RequestParam("b") Integer b);

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    Integer add(@RequestParam("a") Integer a, @RequestParam("b") Integer b);
}
