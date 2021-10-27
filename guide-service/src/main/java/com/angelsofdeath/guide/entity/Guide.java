package com.angelsofdeath.guide.entity;

public class Guide {
    Long id;
    Long userId;
    String name;
    String date;
    String text;
    User user;

    public Guide() {
    }

    public Guide(Long id, Long userId, String name, String date, String text, User user) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.date = date;
        this.text = text;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
