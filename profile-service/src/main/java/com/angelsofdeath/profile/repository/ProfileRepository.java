package com.angelsofdeath.profile.repository;

public class ProfileRepository {
    DbConnector connector = new DbConnector();

    public void updateProfile(String uid, String password, String nickname, String comment) {
        connector.connect();
        connector.updateProfile(uid, password, nickname, comment);
        connector.disconnect();
    }
}
