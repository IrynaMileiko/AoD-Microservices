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
            charClass.setName(rs.getString("classchar.name"));
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
}
