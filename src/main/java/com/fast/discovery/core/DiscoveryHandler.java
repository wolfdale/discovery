package com.fast.discovery.core;

import com.fast.discovery.dto.Acknowledgement;
import com.fast.discovery.dto.ServiceRegistry;
import com.fast.discovery.utility.Utilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
        ConcurrentHashMap<String, List<String>> registry = RegistryMap.getRegistry();

        if (registry.get(serviceRegistry.getServiceName()) != null) {
            log.info("Updating service registry for service Id :" + serviceRegistry.getServiceName());
            List<String> alreadyDiscoveredServices = registry.get(serviceRegistry.getServiceName());
            List<String> newDiscoveredServices = new LinkedList<>();
            newDiscoveredServices.addAll(alreadyDiscoveredServices);

            for (String serviceName : serviceRegistry.getDependsOn()) {
                if (!alreadyDiscoveredServices.contains(serviceName)) {
                    newDiscoveredServices.add(serviceName);
                }
            }

            registry.put(serviceRegistry.getServiceName(), newDiscoveredServices);
            return new Acknowledgement.AckBuilder().ack(true).msg(Utilities.SERVICE_UPDATED).build();
        }
        else {
            log.info("Creating new service registry for  : " + serviceRegistry.getServiceName());
            registry.put(serviceRegistry.getServiceName(), Arrays.asList(serviceRegistry.getDependsOn()));
            return new Acknowledgement.AckBuilder().ack(true).msg(Utilities.SERVICE_REGISTERED).build();
        }
    }

    /**
     * This is currently basic network graph
     * @return JSON Graph of network
     */
    public void buildNetworkGraph() {
        log.info("Building service matrix ..");
        ConcurrentHashMap<String, List<String>> registry = RegistryMap.getRegistry();
        List<String> listOfServices = registry.keySet().stream().collect(Collectors.toList());
        for (String serviceName : registry.keySet()) {
            StringBuilder lineBuilder = new StringBuilder();
            lineBuilder.append(serviceName + " [ ");
            List<String> dependent = registry.get(serviceName);

            for(String allService : listOfServices){
                if(dependent.contains(allService)){
                    lineBuilder.append(allService + " YES ");
                }
                else {
                    lineBuilder.append(allService + " NO ");
                }
            }

            lineBuilder.append(" ] ");
            log.info(lineBuilder.toString());
        }
    }
}
