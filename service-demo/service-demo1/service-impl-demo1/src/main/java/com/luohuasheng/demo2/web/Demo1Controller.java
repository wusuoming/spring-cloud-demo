package com.luohuasheng.demo2.web;

import com.luohuasheng.demo2.facade.Demo1Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author wusuoming
 */
@RestController
public class Demo1Controller implements Demo1Facade {

    private final Logger logger = Logger.getGlobal();
    @Value("${spring.application.name}")
    private String appName;
    @Autowired
    private DiscoveryClient client;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Override
    public List<String> add(Integer a, Integer b) {
        List<String> messages = new ArrayList<>();

        for (String serviceId : client.getServices()) {
            List<ServiceInstance> instances = client.getInstances(serviceId);
            for (ServiceInstance instance : instances) {
                if (!appName.equalsIgnoreCase(serviceId)) {
                    continue;
                }
                Integer r = a + b;
                logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
                messages.add("From " + instance.getServiceId() + ", Result is " + r + "\nPort:" + instance.getPort());
            }
        }

        return messages;
    }


    @Override
    public List<String> sub(Integer a, Integer b) {
        this.loadBalancerClient.choose("service-demo2");
        return restTemplate.exchange("http://service-demo2/sub?a=" + a + "&b=" + b,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {
                }).getBody();

    }


}