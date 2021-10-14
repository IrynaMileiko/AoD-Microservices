package com.angelsofdeath.adminpanel.repository;


import com.angelsofdeath.adminpanel.entity.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

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
}
