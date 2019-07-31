package com.fast.discovery.dto;

public class ServiceRegistry {

    private String serviceName;
    private String instanceId;
    private String instanceIpAddr;
    private String health;
    private String heartBeatUrl;

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public void setInstanceIpAddr(String instanceIpAddr) {
        this.instanceIpAddr = instanceIpAddr;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public void setHeartBeatUrl(String heartBeatUrl) {
        this.heartBeatUrl = heartBeatUrl;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public String getInstanceIpAddr() {
        return instanceIpAddr;
    }

    public String getHealth() {
        return health;
    }

    public String getHeartBeatUrl() {
        return heartBeatUrl;
    }
}
