package com.angelsofdeath.guide.entity;

public class NewEvent {
    String name;
    String text;
    String userId;
    String datetime;

    public NewEvent() {
    }

    public NewEvent(String name, String text, String userId, String datetime) {
        this.name = name;
        this.text = text;
        this.userId = userId;
        this.datetime = datetime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
