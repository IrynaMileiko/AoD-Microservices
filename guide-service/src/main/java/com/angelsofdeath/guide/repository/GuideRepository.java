package com.angelsofdeath.guide.repository;

import com.angelsofdeath.guide.entity.Guide;
import com.angelsofdeath.guide.entity.Role;
import com.angelsofdeath.guide.entity.User;

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
}
