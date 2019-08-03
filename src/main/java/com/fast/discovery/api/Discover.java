package com.fast.discovery.api;

import com.fast.discovery.dto.Acknowledgement;
import com.fast.discovery.dto.ServiceRegistry;
import com.fast.discovery.servicemanager.ServiceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class Discover {
    //TODO Autowiring
    @PutMapping(value = "/register")
    public Acknowledgement registerService(@RequestBody ServiceRegistry serviceRegistry) {
        ServiceHandler discoveryService = new ServiceHandler();
        return discoveryService.serviceRegistration(serviceRegistry);
    }

    @GetMapping(value = "/data")
    public String showData() {
        ServiceHandler discoveryService = new ServiceHandler();

        return discoveryService.showData();
    }

}
