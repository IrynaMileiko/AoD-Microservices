package com.angelsofdeath.adminpanel.repository;

import com.angelsofdeath.adminpanel.entity.Role;
import com.angelsofdeath.adminpanel.entity.User;

import javax.management.relation.Relation;
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

    public void updateUser(String uid, String login, String password, String roleId, String nickname, String comment) {
        connector.connect();
        if (password.equals("")) {
            connector.editUserWOPassword(uid, login, nickname, comment);
        } else {
            connector.editUser(uid, login, password, nickname, comment, roleId);
        }
        connector.disconnect();
    }

    public User getUserByLogin(String login) {
        connector.connect();
        ResultSet rs = connector.getUserByLogin(login);
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
        } catch (
                SQLException e) {
            user = null;
        }
        connector.disconnect();
        return user;
    }

    public User getUserByNickname(String nickname) {
        connector.connect();
        ResultSet rs = connector.getUserByNickname(nickname);
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
        } catch (
                SQLException e) {
            user = null;
        }
        connector.disconnect();
        return user;
    }

    public void deleteUser(String id) {
        connector.connect();
        connector.deleteUser(id);
        connector.disconnect();
    }
}
