package com.angelsofdeath.profile.entity;

import org.springframework.web.bind.annotation.RequestParam;

public class NewChar {
    String name;
    String classId;
    String descr;
    String userId;

    public NewChar() {
    }

    public NewChar(String name, String classId, String descr, String userId) {
        this.name = name;
        this.classId = classId;
        this.descr = descr;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "NewChar{" +
                "name='" + name + '\'' +
                ", classId='" + classId + '\'' +
                ", descr='" + descr + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
