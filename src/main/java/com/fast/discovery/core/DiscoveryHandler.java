package com.fast.discovery.core;

import com.fast.discovery.dto.Acknowledgement;
import com.fast.discovery.dto.ServiceRegistry;
import com.fast.discovery.utility.Utilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class DiscoveryHandler {
    private static final Logger log = LogManager.getLogger(DiscoveryHandler.class);

    /**
     * For creating/updating new service registry.
     * @param serviceRegistry
     * @return Ack
     */
    public Acknowledgement serviceRegistration(ServiceRegistry serviceRegistry) {
        ConcurrentHashMap<String, Set<String>> registry = RegistryMap.getRegistry();

        if (registry.get(serviceRegistry.getServiceName()) != null) {
            log.info("Updating service registry for service Id :" + serviceRegistry.getServiceName());
            Set<String> services = registry.get(serviceRegistry.getServiceName());

            for (String serviceName : serviceRegistry.getDependsOn()) {
                services.add(serviceName);
            }

            log.debug("Current service : " + services.toString());
            registry.put(serviceRegistry.getServiceName(), services);
            return new Acknowledgement.AckBuilder().ack(true).msg(Utilities.SERVICE_UPDATED).build();
        }
        else {
            log.info("Creating new service registry for  : " + serviceRegistry.getServiceName());
            registry.put(serviceRegistry.getServiceName(),
                    Arrays.stream(serviceRegistry.getDependsOn()).collect(Collectors.toSet()));
            return new Acknowledgement.AckBuilder().ack(true).msg(Utilities.SERVICE_REGISTERED).build();
        }
    }

    /**
     * This is currently basic network graph
     * @return JSON Graph of network
     */
    public String buildNetworkGraph() {
        log.debug("Building service matrix ..");
        ConcurrentHashMap<String, Set<String>> registry = RegistryMap.getRegistry();
        StringBuilder sInfo = new StringBuilder();

        for (String serviceName : registry.keySet()) {
            log.debug("Service Name : " + serviceName);
            log.debug("Depends On : " + registry.get(serviceName));
            sInfo.append("Service Name : "+ serviceName + " Depends On : "+ registry.get(serviceName) + "\n");
        }

        return sInfo.toString();
    }
}
