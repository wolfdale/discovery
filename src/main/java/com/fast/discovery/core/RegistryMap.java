package com.fast.discovery.core;

import com.fast.discovery.dto.ServiceRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class RegistryMap {
    private static final Logger log = LogManager.getLogger(RegistryMap.class);

    private static ConcurrentHashMap<String, List<String>> registry;

    public static ConcurrentHashMap<String, List<String>> getRegistry() {
        if (registry == null) {
            log.info("Initializing registry map for first time.");
            registry = new ConcurrentHashMap<>();
        }
        log.info("Getting registry map.");
        return registry;
    }

}
