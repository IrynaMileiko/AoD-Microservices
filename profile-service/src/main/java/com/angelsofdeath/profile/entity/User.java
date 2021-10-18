package com.angelsofdeath.profile.entity;

import java.util.List;

public class User {
    private Long id;
    private String login;
    private String password;
    private String nickname;
    private String comment;
    private String role;
    private int priority;
    private List<Character> characters;

    public User() {
    }

    public User(Long id, String login, String password, String nickname, String comment, String role, int priority, List<Character> characters) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nickname = nickname;
        this.comment = comment;
        this.role = role;
        this.priority = priority;
        this.characters = characters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
