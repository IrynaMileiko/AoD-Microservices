package com.angelsofdeath.adminpanel.repository;

import java.sql.*;

public class DbConnector {
    private final String db_name = "guild_site_db";
    private final String url = "jdbc:mysql://localhost:3307/" + db_name + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private Connection con;
    private final String user = "root", password = "root";
    private String sql;

    public void connect() {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUsers(String sortColumn, boolean direct, int priority) {
        try {
            ResultSet rs;
            String sql = "SELECT * FROM user JOIN role ON user.roleId=role.id\n" +
                    "WHERE priority<" + priority + "\n" +
                    "ORDER BY " + sortColumn + " " + (direct ? "ASC" : "DESC");
            Statement stat = con.createStatement();
            rs = stat.executeQuery(sql);
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet getRole(Long rId){
        try {
            ResultSet rs;
            String sql = "SELECT * FROM role\n" +
                    "WHERE id=" + rId;
            Statement stat = con.createStatement();
            rs = stat.executeQuery(sql);
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet getUser(Long uId) {
        try {
            ResultSet rs;
            String sql = "SELECT * FROM user\n" +
                    "WHERE id=" + uId;
            Statement stat = con.createStatement();
            rs = stat.executeQuery(sql);
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public String[] isThereUser(String login, String password) {
        String res[] = {"-1", ""}; // id, priority
        ResultSet rs;
        String sql = "SELECT * FROM user JOIN role ON user.roleId=role.id " +
                "WHERE login='" + login+"'";
        Statement st = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (!rs.next()) {
                return res;
            }
            if (password.equals(rs.getString("password"))) {
                res[0] = rs.getString("id");
                res[1] = rs.getString("priority");
                return res;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public String getUser(String login) {
        try {
            ResultSet rs;
            String sql = "SELECT * FROM user\n" +
                    "WHERE login='" + login+"'";
            Statement stat = con.createStatement();
            rs = stat.executeQuery(sql);
            rs.next();
            return rs.getString("id");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet getRoles(int priority) {
        try {
            ResultSet rs;
            String sql = "SELECT * FROM `role`\n" +
                    "WHERE priority<" + priority;
            Statement stat = con.createStatement();
            rs = stat.executeQuery(sql);
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void editUser(String uId, String login, String password, String username, String comment, String rId) {
        try {
            String sql = "UPDATE user set login=\"" + login + "\", password=\"" + password + "\", nickname=\"" + username +
                    "\", comment=\"" + comment + "\", roleId=\"" + rId + "\" WHERE id=" + uId;
            Statement stat = con.createStatement();
            stat.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteUser(String uId) {
        try {
            String sql = "DELETE FROM user WHERE id=" + uId;
            Statement stat = con.createStatement();
            stat.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addUser(String username, String login, String password) {
        try {
            String sql = "INSERT into user(login, password, roleId, nickname) values ('" + login + "', '" +
                    password + "', '" + "1', '" + username + "');";
            Statement stat = con.createStatement();
            stat.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
