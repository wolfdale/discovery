package com.fast.discovery.dto;

import java.util.List;

/**
 * @Desc - Microservice Registry DTO
 * @Author - wolfdale
 */
public class ServiceRegistry {
    private String serviceName;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String[] getDependsOn() {
        return dependsOn;
    }

    public void setDependsOn(String[] dependsOn) {
        this.dependsOn = dependsOn;
    }

    private String[] dependsOn;


}
