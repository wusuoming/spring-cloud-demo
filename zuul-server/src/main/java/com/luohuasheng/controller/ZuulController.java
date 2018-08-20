package com.luohuasheng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZuulController {

    @Autowired
    private ZuulProperties zuulProperties;

    @RequestMapping(value = "getZuulProperties", method = RequestMethod.GET)
    @ResponseBody
    public ZuulProperties getZuulProperties() {
        return zuulProperties;
    }
}
