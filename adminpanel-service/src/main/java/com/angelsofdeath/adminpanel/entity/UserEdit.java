package com.angelsofdeath.adminpanel.entity;

public class UserEdit {
    String uid, login, password, roleId, nickname, comment;


    public UserEdit() {
    }

    public UserEdit(String uid, String login, String password, String roleId, String nickname, String comment) {
        this.uid = uid;
        this.login = login;
        this.password = password;
        this.roleId = roleId;
        this.nickname = nickname;
        this.comment = comment;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
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
}
