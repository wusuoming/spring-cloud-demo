package com.luohuasheng.demo2.facade;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface Demo1Facade {
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    List<String> add(@RequestParam Integer a, @RequestParam Integer b);

    @RequestMapping(value = "/sub", method = RequestMethod.GET)
    List<String> sub(@RequestParam Integer a, @RequestParam Integer b);
}
