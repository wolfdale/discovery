package com.fast.discovery.servicemanager;

import com.fast.discovery.dto.Acknowledgement;
import com.fast.discovery.dto.ServiceRegistry;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceHandler {
    ConcurrentHashMap<String, ServiceRegistry> registry = new ConcurrentHashMap<String, ServiceRegistry>();

    public Acknowledgement serviceRegistration(ServiceRegistry serviceRegistry) {
        Acknowledgement ack = new Acknowledgement();
        registry.put(serviceRegistry.getServiceName(), serviceRegistry);
        ack.setAck(true);
        return ack;
    }

    public String showData() {
        //TODO
        return null;
    }
}
