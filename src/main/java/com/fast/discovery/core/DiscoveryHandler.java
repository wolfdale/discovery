package com.fast.discovery.core;

import com.fast.discovery.dto.Acknowledgement;
import com.fast.discovery.dto.ServiceRegistry;
import com.fast.discovery.utility.Utilities;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ConcurrentHashMap;

public class DiscoveryHandler {
    private static final Logger log = LogManager.getLogger(DiscoveryHandler.class);

    /**
     *
     * @param serviceRegistry
     * @return Ack
     */
    public Acknowledgement serviceRegistration(ServiceRegistry serviceRegistry) {
        ConcurrentHashMap<String, ServiceRegistry.InstanceInfo> registry = RegisteryMap.getRegistry();
        if (registry.get(serviceRegistry.getInstanceId()) == null) {
            log.info("Registering Instance ID : " + serviceRegistry.getInstanceId());
            registry.put(serviceRegistry.getInstanceId(), serviceRegistry.getInstanceInformation());
            return new Acknowledgement.AckBuilder().ack(true).msg(Utilities.SERVICE_REGISTERED).build();
        } else {
            log.error("Instance ID {} is already registered.", serviceRegistry.getInstanceId());
            return new Acknowledgement.AckBuilder().ack(false).msg(Utilities.SERVICE_ALREADY_REGISTERED).build();
        }
    }

    /**
     * This is currently basic network graph
     * @return JSON Graph of network
     */
    public String buildNetworkGraph() {
        log.info("Building micro service network graph..");
        ConcurrentHashMap<String, ServiceRegistry.InstanceInfo> registry = RegisteryMap.getRegistry();
        Gson gson = new Gson();
        String jsonBlockPerInstance = gson.toJson(registry);
        return jsonBlockPerInstance;
    }


}
