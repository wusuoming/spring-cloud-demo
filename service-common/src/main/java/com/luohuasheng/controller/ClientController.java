package com.luohuasheng.controller;

import com.luohuasheng.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panda
 */
@RequestMapping(value = "/common")
public class ClientController {
    @Autowired
    private DiscoveryClient client;


    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    @ResponseBody
    public List<ServiceInstance> clients() {
        List<ServiceInstance> serviceInstances = new ArrayList<>();
        for (String serviceId : client.getServices()) {
            serviceInstances.addAll(client.getInstances(serviceId));
        }

        return serviceInstances;
    }

    @RequestMapping(value = "/language", method = RequestMethod.GET)
    @ResponseBody
    public String language(String code) {
        throw BaseException.create(code, "其他");
    }
}
