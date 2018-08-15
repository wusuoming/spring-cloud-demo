package com.luohuasheng.web;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class ComputeController {

    private final Logger logger = Logger.getGlobal();

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/sub", method = RequestMethod.GET)
    public List<String> sub(@RequestParam Integer a, @RequestParam Integer b) {
        List<String> messages = Lists.newArrayList();

        for (String serviceId : client.getServices()) {
            List<ServiceInstance> instances = client.getInstances(serviceId);
            for (ServiceInstance instance : instances) {
                Integer r = a - b;
                logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
                messages.add("From service-demo2, Result is " + r + "\nPort:" + instance.getPort());
            }
        }

        return messages;
    }

    @RequestMapping(value = "testServiceA", method = RequestMethod.GET)
    public String testServiceB(@RequestParam Integer a, @RequestParam Integer b) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:7074/add?a=" + a + "&b=" + b, String.class);
    }
}