package com.luohuasheng.rule;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author panda
 */
public class TestRandomRule extends RandomRule {

    private TestModel model;
    @Value("${spring.cloud.client.ip-address}")
    private String ip;
    @Value("${spring.cloud.test.local-ips:}")
    private List<String> localIps;
    @Value("${spring.cloud.test.remote-ips:}")
    private List<String> remoteIps;

    public TestRandomRule() {

    }

    public TestRandomRule(TestModel model) {
        this.model = model;
    }


    @Override
    public Server choose(ILoadBalancer lb, Object key) {
        if (model.equals(TestModel.LOCAL)) {
            List<Server> servers = lb.getReachableServers();
            for (Server server : servers) {
                if (server.getHost().equals(ip) || localIps.contains(server.getHost())) {
                    return server;
                }
            }

        } else {
            Server server = super.choose(lb, key);
            if (!CollectionUtils.isEmpty(remoteIps)) {
                if (remoteIps.contains(server.getHost())) {
                    return server;
                } else {
                    return choose(lb, key);
                }
            }
        }
        return super.choose(lb, key);
    }
}
