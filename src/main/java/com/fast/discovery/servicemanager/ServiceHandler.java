package com.fast.discovery.servicemanager;

import com.fast.discovery.dto.Acknowledgement;

import java.util.concurrent.ConcurrentHashMap;

public class ServiceHandler {

    public Acknowledgement serviceRegistration(){
        Acknowledgement ack = new Acknowledgement();
        ack.setAck(true);
        return ack;
    }
}
