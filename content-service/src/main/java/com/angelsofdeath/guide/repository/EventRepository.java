package com.angelsofdeath.guide.repository;

import com.angelsofdeath.guide.entity.Event;
import com.angelsofdeath.guide.entity.Guide;
import com.angelsofdeath.guide.entity.Role;
import com.angelsofdeath.guide.entity.User;

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

    public Event getEvent(String id) {
        connector.connect();
        ResultSet rs = connector.getEvent(id);
        Event event = new Event();
        try {
            rs.next();
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

        } catch (SQLException e) {
            return null;
        }
        connector.disconnect();
        return event;
    }

    public void editEvent(String id, String name, String text, String date) {
        connector.connect();
        connector.editEvent(id, name, text, date);
        connector.disconnect();
    }

    public void addEvent(String userId, String name, String text, String date) {
        connector.connect();
        connector.addEvent(userId,name,text,date);
        connector.disconnect();
    }

    public boolean isUsersEvent(String chId, String userId) {
        connector.connect();
        ResultSet rs = connector.getEUs(chId, userId);
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

    public void deleteGuide(String id) {
        connector.connect();
        connector.deleteEvent(id);
        connector.disconnect();
    }
}
