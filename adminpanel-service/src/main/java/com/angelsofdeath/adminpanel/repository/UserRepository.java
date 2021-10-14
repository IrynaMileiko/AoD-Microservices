package com.angelsofdeath.adminpanel.repository;

import com.angelsofdeath.adminpanel.entity.Role;
import com.angelsofdeath.adminpanel.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class UserRepository {
    RoleRepository roleRepository = new RoleRepository();
    private DbConnector connector = new DbConnector();

    public User getUser(Long userId) {
        connector.connect();
        ResultSet rs = connector.getUser(userId);
        User user = new User();
        try {
            rs.next();
            user.setId(rs.getLong("id"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setRoleId(rs.getLong("roleId"));
            user.setNickname(rs.getString("nickname"));
            user.setComment(rs.getString("comment"));
            user.setRole(roleRepository.getRole(user.getRoleId()));
        } catch (SQLException e) {
            user = null;
        }
        connector.disconnect();
        return user;
    }

    public List<User> getAllUsers(String sortColumn, boolean direct, int priority) {
        connector.connect();
        ResultSet rs = connector.getUsers(sortColumn, direct, priority);
        List<User> users = new LinkedList<>();
        try {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setRoleId(rs.getLong("roleId"));
                user.setNickname(rs.getString("nickname"));
                user.setComment(rs.getString("comment"));
                user.setRole(roleRepository.getRole(user.getRoleId()));
                users.add(user);
            }
        } catch (SQLException e) {

        }
        connector.disconnect();
        return users;
    }
}
