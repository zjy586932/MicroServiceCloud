package com.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MyRule extends AbstractLoadBalancerRule {
    private AtomicInteger total = new AtomicInteger();
    private AtomicInteger index = new AtomicInteger();

    /**
     * Randomly choose from all living servers
     */
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if(Thread.interrupted()){
                return null;
            }
            List<Server> allServers = lb.getAllServers();
            List<Server> reachableServers = lb.getReachableServers();

            int length = allServers.size();
            int reachableLength = reachableServers.size();
            if(length==0){
                return null;
            }
            //total从0->5
            if(total.getAndIncrement()<5){
                server = reachableServers.get(index.get());

            }else{
                total.compareAndSet(6,0);
                if(index.getAndIncrement()==reachableLength-1){
                    index.compareAndSet(reachableLength,0);
                }
                server = reachableServers.get(index.get());
            }
        }
        return server;
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}
