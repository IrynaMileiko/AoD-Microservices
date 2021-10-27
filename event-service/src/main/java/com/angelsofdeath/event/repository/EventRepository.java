package com.angelsofdeath.event.repository;

import com.angelsofdeath.event.entity.Event;
import com.angelsofdeath.event.entity.Role;
import com.angelsofdeath.event.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EventRepository {
    private DbConnector connector = new DbConnector();

    public List<Event> getAllEvents() {
        connector.connect();
        ResultSet rs = connector.getEvents();
        List<Event> events = new LinkedList<>();
        try {
            while (rs.next()) {
                Event event = new Event();
                event.setId(rs.getLong("event.id"));
                event.setUserId(rs.getLong("user.id"));
                event.setDate(rs.getString("date"));
                event.setName(rs.getString("event.name"));
                event.setText(rs.getString("text"));

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
                event.setUser(user);

                events.add(event);
            }
        } catch (SQLException e) {

        }
        connector.disconnect();
        return events;
    }
}
