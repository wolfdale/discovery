package com.fast.discovery.dto;

/**
 * @Desc - ACK/NACK class for micro service registry.
 * @Author - wolfdale
 */
public class Acknowledgement {
    private boolean ack;
    private String msg;

    public boolean isAck() {
        return ack;
    }

    public String getMsg() {
        return msg;
    }

    private Acknowledgement(AckBuilder builder) {
        this.ack = builder.ack;
        this.msg = builder.msg;
    }

    public static class AckBuilder {
        private boolean ack;
        private String msg;

        public AckBuilder ack(boolean ack) {
            this.ack = ack;
            return this;
        }

        public AckBuilder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public Acknowledgement build() {
            Acknowledgement ackObj = new Acknowledgement(this);
            return ackObj;
        }
    }
}
