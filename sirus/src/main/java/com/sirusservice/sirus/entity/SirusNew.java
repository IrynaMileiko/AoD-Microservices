package com.sirusservice.sirus.entity;

public class SirusNew {
    String date;
    String name;
    String href;

    public SirusNew() {
    }

    public SirusNew(String date, String name, String href) {
        this.date = date;
        this.name = name;
        this.href = href;
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

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
