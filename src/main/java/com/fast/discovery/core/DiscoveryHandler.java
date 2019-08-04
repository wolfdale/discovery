package com.fast.discovery.core;

import com.fast.discovery.dto.Acknowledgement;
import com.fast.discovery.dto.ServiceRegistry;
import com.fast.discovery.utility.Utilities;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class DiscoveryHandler {
    private static final Logger log = LogManager.getLogger(DiscoveryHandler.class);

    private static ConcurrentHashMap<String, List<ServiceRegistry.InstanceInfo>> registry =
            new ConcurrentHashMap<String, List<ServiceRegistry.InstanceInfo>>();

    public Acknowledgement serviceRegistration(ServiceRegistry serviceRegistry) {
        Acknowledgement ack = new Acknowledgement();
        if (registry.get(serviceRegistry.getInstanceId()) == null) {
            log.info("Registering Instance ID : " + serviceRegistry.getInstanceId());
            registry.put(serviceRegistry.getInstanceId(), serviceRegistry.getInstanceInformation());
            ack.setAck(true);
            ack.setMsg(Utilities.SERVICE_REGISTERED);
        } else {
            log.error("Instance ID {} is already registered.", serviceRegistry.getInstanceId());
            ack.setAck(false);
            ack.setMsg(Utilities.SERVICE_ALREADY_REGISTERED);
        }
        return ack;
    }

    public String buildNetworkGraph() {
        log.info("Building micro service network graph..");
        Gson gson = new Gson();
        String jsonBlockPerInstance = gson.toJson(registry);
        return jsonBlockPerInstance;
    }
}
