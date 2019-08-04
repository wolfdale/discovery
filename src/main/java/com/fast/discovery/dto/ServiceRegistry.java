package com.fast.discovery.dto;

/**
 * @Desc - Microservice Registry DTO
 * @Author - wolfdale
 */
public class ServiceRegistry {
    private String instanceId;
    private InstanceInfo instanceInformation;

    public static class InstanceInfo {
        private String serviceName;
        private String instanceIpAddr;
        private String health;
        private String heartBeatUrl;

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        public String getInstanceIpAddr() {
            return instanceIpAddr;
        }

        public void setInstanceIpAddr(String instanceIpAddr) {
            this.instanceIpAddr = instanceIpAddr;
        }

        public String getHealth() {
            return health;
        }

        public void setHealth(String health) {
            this.health = health;
        }

        public String getHeartBeatUrl() {
            return heartBeatUrl;
        }

        public void setHeartBeatUrl(String heartBeatUrl) {
            this.heartBeatUrl = heartBeatUrl;
        }
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public InstanceInfo getInstanceInformation() {
        return instanceInformation;
    }

    public void setInstanceInformation(InstanceInfo instanceInformation) {
        this.instanceInformation = instanceInformation;
    }
}
