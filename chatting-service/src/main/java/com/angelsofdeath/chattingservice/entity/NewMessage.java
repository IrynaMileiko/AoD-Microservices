package com.angelsofdeath.chattingservice.entity;

public class NewMessage {
    String userId, msgTxt, dateTime;

    public NewMessage() {
    }

    public NewMessage(String userId, String msgTxt, String dateTime) {
        this.userId = userId;
        this.msgTxt = msgTxt;
        this.dateTime = dateTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMsgTxt() {
        return msgTxt;
    }

    public void setMsgTxt(String msgTxt) {
        this.msgTxt = msgTxt;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
