package com.fast.discovery.core;

import com.fast.discovery.dto.ServiceRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ConcurrentHashMap;

public class RegisteryMap {
    private static final Logger log = LogManager.getLogger(RegisteryMap.class);

    private static ConcurrentHashMap<String, ServiceRegistry.InstanceInfo> registry;

    public static ConcurrentHashMap<String, ServiceRegistry.InstanceInfo> getRegistry() {
        if (registry == null) {
            log.info("Initializing registry map for first time.");
            registry = new ConcurrentHashMap<String, ServiceRegistry.InstanceInfo>();
        }
        log.info("Getting registry map.");
        return registry;
    }

}
