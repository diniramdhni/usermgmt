package com.usermgmt;

public class ErrorResponse {
    private int status;
    private Object messages;
    private  long timeStamp;

    public ErrorResponse(){}

    public ErrorResponse(int status, Object messages, long timeStamp) {
        this.status = status;
        this.messages = messages;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getMessages() {
        return messages;
    }

    public void setMessages(Object messages) {
        this.messages = messages;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
