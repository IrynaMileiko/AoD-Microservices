package com.angelsofdeath.event.entity;

import java.util.Date;

public class Event {
    Long id;
    Long userId;
    String date;
    String name;
    String text;
    User user;

    public Event() {
    }

    public Event(Long id, Long userId, String date, String name, String text, User user) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.name = name;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", userId=" + userId +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", user=" + user.toString() +
                '}';
    }
}
