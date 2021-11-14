package com.angelsofdeath.authorization.entity;

public class LUCheckGet {
    String userID;
    String login;
    String nickname;

    public LUCheckGet() {
    }

    public LUCheckGet(String userID, String login, String nickname) {
        this.userID = userID;
        this.login = login;
        this.nickname = nickname;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
