package com.luohuasheng.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class Demo2Controller {

    private final Logger logger = Logger.getGlobal();

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private DiscoveryClient client;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/sub", method = RequestMethod.GET)
    public List<String> sub(@RequestParam Integer a, @RequestParam Integer b) {
        List<String> messages = new ArrayList<>();

        for (String serviceId : client.getServices()) {
            List<ServiceInstance> instances = client.getInstances(serviceId);
            for (ServiceInstance instance : instances) {
                if (!appName.equalsIgnoreCase(serviceId)) {
                    continue;
                }
                Integer r = a - b;
                logger.info("/sub, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
                messages.add("From " + instance.getServiceId() + ", Result is " + r + "\nPort:" + instance.getPort());
            }
        }

        return messages;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@RequestParam Integer a, @RequestParam Integer b) {
        this.loadBalancerClient.choose("service-demo1");
        return restTemplate.getForEntity("http://service-demo1/add?a=" + a + "&b=" + b, String.class).getBody();

    }
}