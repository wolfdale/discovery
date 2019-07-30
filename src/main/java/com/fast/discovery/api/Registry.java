package com.fast.discovery.api;

import com.fast.discovery.dto.Acknowledgement;
import com.fast.discovery.dto.ServiceRegistry;
import com.fast.discovery.servicemanager.ServiceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Registry {

    @Autowired
    ServiceHandler sh;


    @PutMapping(value = "/register")
    public Acknowledgement registerService(@RequestBody ServiceRegistry serviceRegistry) {

        return sh.serviceRegistration();

    }

}
