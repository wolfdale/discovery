package com.fast.discovery.api;

import com.fast.discovery.dto.Acknowledgement;
import com.fast.discovery.dto.ServiceRegistry;
import com.fast.discovery.core.DiscoveryHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Discover {
    //TODO Autowiring
    @PutMapping(value = "/register")
    public Acknowledgement registerService(@RequestBody ServiceRegistry serviceRegistry) {
        DiscoveryHandler discoveryService = new DiscoveryHandler();
        return discoveryService.serviceRegistration(serviceRegistry);
    }

    @GetMapping(value = "/netgraph")
    public String showData() {
        DiscoveryHandler discoveryService = new DiscoveryHandler();
        return discoveryService.buildNetworkGraph();
    }
}