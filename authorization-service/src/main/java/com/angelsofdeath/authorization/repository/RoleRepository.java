package com.angelsofdeath.authorization.repository;

import com.angelsofdeath.authorization.entity.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class RoleRepository {
    private DbConnector connector = new DbConnector();

    public Role getRole(Long roleId) {
        connector.connect();
        ResultSet rs = connector.getRole(roleId);
        Role role = new Role();
        try {
            rs.next();
            role.setId(rs.getLong("id"));
            role.setName(rs.getString("name"));
            role.setPriority(rs.getInt("priority"));
        } catch (SQLException e) {
            role = null;
        }
        connector.disconnect();
        return role;
    }

    public List<Role> getRolesBelowPriority(int priority) {
        connector.connect();
        ResultSet rs = connector.getRoles(priority);
        List<Role> roles = new LinkedList<>();
        try {
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getLong("id"));
                role.setName(rs.getString("name"));
                role.setPriority(rs.getInt("priority"));
                roles.add(role);
            }
        } catch (SQLException e) {

        }
        connector.disconnect();
        return roles;
    }
}

