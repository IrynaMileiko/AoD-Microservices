package com.angelsofdeath.authorization.entity;

public class User {
    private Long id;
    private String login;
    private String password;
    private Long roleId;
    private String nickname;
    private String comment;
    private com.angelsofdeath.authorization.entity.Role role;

    public User(Long id, String login, String password, Long roleId, String nickname, String comment, com.angelsofdeath.authorization.entity.Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.roleId = roleId;
        this.nickname = nickname;
        this.comment = comment;
        this.role = role;
    }

    public User() {
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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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

    public com.angelsofdeath.authorization.entity.Role getRole() {
        return role;
    }

    public void setRole(com.angelsofdeath.authorization.entity.Role role) {
        this.role = role;
    }
}