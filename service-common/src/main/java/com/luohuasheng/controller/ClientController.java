package com.luohuasheng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/common")
public class ClientController {
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public List<ServiceInstance> clients() {
        List<ServiceInstance> serviceInstances = new ArrayList<>();
        for (String serviceId : client.getServices()) {
            serviceInstances.addAll(client.getInstances(serviceId));
        }
        return serviceInstances;
    }
}
