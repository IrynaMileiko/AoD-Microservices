package com.angelsofdeath.profile.repository;

import com.angelsofdeath.profile.entity.CharClass;
import com.angelsofdeath.profile.entity.Character;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CharacterRepository {
    DbConnector connector = new DbConnector();

    public Character getCharacter(String id) {
        connector.connect();
        ResultSet rs = connector.getCharacter(id);
        Character character = new Character();
        try {
            rs.next();
            character.setId(rs.getLong("gamechar.id"));
            character.setName(rs.getString("gamechar.name"));
            character.setDescription(rs.getString("description"));

            CharClass charClass = new CharClass();
            charClass.setId(rs.getLong("charclass.id"));
            charClass.setName(rs.getString("charclass.name"));
            charClass.setImg(rs.getString("img"));
            character.setCharClass(charClass);
        } catch (
                SQLException e) {
            character = null;
        }
        connector.disconnect();
        return character;
    }

    public List<Character> getUserCharacters(String id) {
        connector.connect();
        ResultSet rs = connector.getUserCharacters(id);
        List<Character> characters = new LinkedList<>();
        try {
            while (rs.next()) {
                Character character = new Character();
                character.setId(rs.getLong("gamechar.id"));
                character.setName(rs.getString("gamechar.name"));
                character.setDescription(rs.getString("description"));
                if (character.getDescription() == null) character.setDescription("");

                CharClass charClass = new CharClass();
                charClass.setId(rs.getLong("charclass.id"));
                charClass.setName(rs.getString("charclass.name"));
                charClass.setImg(rs.getString("img"));
                character.setCharClass(charClass);
                characters.add(character);
            }
        } catch (SQLException e) {

        }
        connector.disconnect();
        return characters;
    }

    public List<CharClass> getAllClasses() {
        connector.connect();
        ResultSet rs = connector.getAllClasses();
        List<CharClass> classes = new LinkedList<>();
        try {
            while (rs.next()) {
                CharClass charClass = new CharClass();
                charClass.setId(rs.getLong("charclass.id"));
                charClass.setName(rs.getString("charclass.name"));
                charClass.setImg(rs.getString("img"));
                classes.add(charClass);
            }
        } catch (SQLException e) {

        }
        connector.disconnect();
        return classes;
    }

    public Boolean getCharByName(String name) {
        connector.connect();
        ResultSet rs = connector.getCharByName(name);
        try {
            if (rs.next()) {
                connector.disconnect();
                return true;
            }
            connector.disconnect();
            return false;
        } catch (SQLException e) {
        }
        connector.disconnect();
        return false;
    }

    public void addCharacter(String name, String classId, String descr, String userId) {
        connector.connect();
        connector.addCharacter(name, classId, descr, userId);
        connector.disconnect();
    }

    public void deleteCharacter(String chId) {
        connector.connect();
        connector.deleteCharacter(chId);
        connector.disconnect();
    }

    public boolean isUsersChar(String chId, String userId) {
        connector.connect();
        ResultSet rs = connector.getChUs(chId, userId);
        try {
            if (rs.next()) {
                connector.disconnect();
                return true;
            }
            connector.disconnect();
            return false;
        } catch (SQLException e) {
        }
        connector.disconnect();
        return false;
    }

    public Boolean getCharByNameId(String name, String chId) {
        connector.connect();
        ResultSet rs = connector.getCharByNameId(name, chId);
        try {
            if (rs.next()) {
                connector.disconnect();
                return true;
            }
            connector.disconnect();
            return false;
        } catch (SQLException e) {
        }
        connector.disconnect();
        return false;
    }

    public void editCharacter(String chId, String name, String classId, String descr) {
        connector.connect();
        connector.editCharacter(chId, name, classId, descr);
        connector.disconnect();
    }
}
