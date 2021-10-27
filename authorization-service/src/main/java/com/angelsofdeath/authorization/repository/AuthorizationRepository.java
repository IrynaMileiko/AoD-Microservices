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

        ResultSet rs = connector.getUserByLP(login,password);
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

    public Boolean getUserByLogin(String login) {
        connector.connect();

        ResultSet rs = connector.getUserByLogin(login);
        try {
            if(rs.next()){
                connector.disconnect();
                return true;
            }
            else{
                connector.disconnect();
                return false;
            }
        } catch (SQLException e) {

        }
        connector.disconnect();
        return false;
    }

    public Boolean getUserByUsername(String username) {
        connector.connect();

        ResultSet rs = connector.getUserByNickname(username);
        try {
            if(rs.next()){
                connector.disconnect();
                return true;
            }
            else{
                connector.disconnect();
                return false;
            }
        } catch (SQLException e) {

        }
        connector.disconnect();
        return false;
    }

    public LUCheck getUserByLU(String login, String username) {
        LUCheck luc = new LUCheck();
        connector.connect();
        luc.setLogin(getUserByLogin(login));
        luc.setUsername(getUserByUsername(username));
        connector.disconnect();
        return luc;
    }
}
