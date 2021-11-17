package com.angelsofdeath.services.repository;

import com.angelsofdeath.services.entity.Guide;
import com.angelsofdeath.services.entity.Role;
import com.angelsofdeath.services.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class GuideRepository {
    private DbConnector connector = new DbConnector();


    public List<Guide> getAllGuides() {
        connector.connect();
        ResultSet rs = connector.getGuides();
        List<Guide> guides = new LinkedList<>();
        try {
            while (rs.next()) {
                Guide guide = new Guide();
                guide.setId(rs.getLong("guide.id"));
                guide.setUserId(rs.getLong("user.id"));
                guide.setDate(rs.getString("date"));
                guide.setName(rs.getString("guide.name"));
                guide.setText(rs.getString("text"));

                Role role = new Role();
                role.setId(rs.getLong("role.id"));
                role.setName(rs.getString("role.name"));
                role.setPriority(rs.getInt("priority"));

                User user = new User();
                user.setId(rs.getLong("user.id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setRoleId(rs.getLong("roleId"));
                user.setNickname(rs.getString("nickname"));
                user.setComment(rs.getString("comment"));

                user.setRole(role);
                guide.setUser(user);

                guides.add(guide);
            }
        } catch (SQLException e) {

        }
        connector.disconnect();
        return guides;
    }

    public Guide getGuide(String id) {
        connector.connect();
        ResultSet rs = connector.getGuide(id);
        Guide guide = new Guide();
        try {
            rs.next();
            guide.setId(rs.getLong("guide.id"));
            guide.setUserId(rs.getLong("user.id"));
            guide.setDate(rs.getString("date"));
            guide.setName(rs.getString("guide.name"));
            guide.setText(rs.getString("text"));

            Role role = new Role();
            role.setId(rs.getLong("role.id"));
            role.setName(rs.getString("role.name"));
            role.setPriority(rs.getInt("priority"));

            User user = new User();
            user.setId(rs.getLong("user.id"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setRoleId(rs.getLong("roleId"));
            user.setNickname(rs.getString("nickname"));
            user.setComment(rs.getString("comment"));

            user.setRole(role);
            guide.setUser(user);

        } catch (SQLException e) {
            return null;
        }
        connector.disconnect();
        return guide;
    }

    public boolean isUsersGuide(String chId, String userId) {
        connector.connect();
        ResultSet rs = connector.getGUs(chId, userId);
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

    public void editGuide(String id, String name, String text) {
        connector.connect();
        connector.editGuide(id, name, text);
        connector.disconnect();
    }

    public void addGuide(String userId, String name, String text, String date) {
        connector.connect();
        connector.addGuide(userId,name,text,date);
        connector.disconnect();
    }

    public void deleteGuide(String id) {
        connector.connect();
        connector.deleteGuide(id);
        connector.disconnect();
    }
}
