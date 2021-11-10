package com.angelsofdeath.guide.entity;

public class NewGuide {
    String name;
    String text;
    String userId;

    public NewGuide() {
    }

    public NewGuide(String name, String text, String userId) {
        this.name = name;
        this.text = text;
        this.userId = userId;
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
}
