package com.fast.discovery.servicemanager;

import com.fast.discovery.dto.Acknowledgement;
import com.fast.discovery.dto.ServiceRegistry;
import com.google.gson.Gson;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceHandler {
    ConcurrentHashMap<String, List<ServiceRegistry.InstanceInfo>> registry =
            new ConcurrentHashMap<String, List<ServiceRegistry.InstanceInfo>>();

    public Acknowledgement serviceRegistration(ServiceRegistry serviceRegistry) {
        Acknowledgement ack = new Acknowledgement();
        if (registry.get(serviceRegistry.getServiceName()) != null) {
            List<ServiceRegistry.InstanceInfo> instanceInfo = registry.get(serviceRegistry.getServiceName());
            instanceInfo.addAll(serviceRegistry.getInstanceInformation());
            registry.put(serviceRegistry.getServiceName(), instanceInfo);
        } else {
            System.out.println("Registering  " + serviceRegistry.getServiceName());
            registry.put(serviceRegistry.getServiceName(), serviceRegistry.getInstanceInformation());
        }
        ack.setAck(true);
        return ack;
    }

    public String showData() {
        StringBuilder sb = new StringBuilder();
        Gson json = new Gson();
        for (String s : registry.keySet()) {
            System.out.println(s);
        }
        return json.toJson(registry);
    }
}
