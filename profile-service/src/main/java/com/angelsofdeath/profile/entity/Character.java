package com.angelsofdeath.profile.entity;

public class Character {
    private Long id;
    private String name;
    private CharClass charClass;
    private String description;

    public Character() {
    }

    public Character(Long id, String name, CharClass charClass, String description) {
        this.id = id;
        this.name = name;
        this.charClass = charClass;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharClass getCharClass() {
        return charClass;
    }

    public void setCharClass(CharClass charClass) {
        this.charClass = charClass;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
