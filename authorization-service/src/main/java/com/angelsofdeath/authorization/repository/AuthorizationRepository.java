package com.angelsofdeath.authorization.repository;

import com.angelsofdeath.authorization.entity.LUCheck;
import com.angelsofdeath.authorization.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorizationRepository {
    private DbConnector connector = new DbConnector();
    private RoleRepository roleRepository = new RoleRepository();

    public User getUser(String login, String password) {
        connector.connect();

        ResultSet rs = connector.getUserByLP(login, password);
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
        }
        connector.disconnect();
        return user;
    }

    public User addUser(String username, String login, String password) {
        connector.connect();

        connector.addUser(username, login, password);
        ResultSet rs = connector.getLastUser();
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

    public Boolean getUserByLogin(String login, String userID) {
        connector.connect();

        ResultSet rs = connector.checkSelfLogin(login, userID);
        try {
            if (rs.next()) {
                connector.disconnect();
                return true;
            } else {
                connector.disconnect();
                return false;
            }
        } catch (SQLException e) {

        }
        connector.disconnect();
        return false;
    }

    public Boolean getUserByUsername(String username, String userID) {
        connector.connect();

        ResultSet rs = connector.checkSelfUsername(username, userID);
        try {
            if (rs.next()) {
                connector.disconnect();
                return true;
            } else {
                connector.disconnect();
                return false;
            }
        } catch (SQLException e) {

        }
        connector.disconnect();
        return false;
    }

    public LUCheck getUserByLU(String login, String username, String userID) {
        LUCheck luc = new LUCheck();
        connector.connect();
        luc.setLogin(getUserByLogin(login, userID));
        luc.setUsername(getUserByUsername(username, userID));
        connector.disconnect();
        return luc;
    }

    public Boolean getUserByUserIdPassword(String uId, String password) {
        connector.connect();
        ResultSet rs = connector.getUser(Long.parseLong(uId));
        try {
            if (rs.next()) {
                if (rs.getString("password").equals(password)) {
                    connector.disconnect();
                    return true;
                } else {
                    connector.disconnect();
                    return false;
                }
            } else {
                connector.disconnect();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connector.disconnect();
        return false;
    }
}
