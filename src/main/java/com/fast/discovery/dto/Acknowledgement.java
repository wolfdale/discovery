package com.fast.discovery.dto;

/**
 * @Desc - ACK/NACK class for microservice registry.
 * @Author - wolfdale
 */
public class Acknowledgement {
    private boolean ack;
    private String msg;

    public boolean isAck() {
        return ack;
    }

    public void setAck(boolean ack) {
        this.ack = ack;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
