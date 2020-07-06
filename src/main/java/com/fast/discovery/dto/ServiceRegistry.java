package com.fast.discovery.dto;

import java.util.List;

/**
 * @Desc - Microservice Registry DTO
 * @Author - wolfdale
 */
public class ServiceRegistry {
    private String serviceName;
    private String[] dependsOn;

    public String getServiceName() {
        return serviceName;
    }

    public String[] getDependsOn() {
        return dependsOn;
    }


}
