package com.angelsofdeath.guide.repository;

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

    public ResultSet getEvents() {
        try {
            ResultSet rs;
            String sql = "SELECT * FROM event JOIN user JOIN role\n" +
                    "ON event.userId = user.id AND user.roleId = role.id\n" +
                    "ORDER BY DATE DESC;";
            Statement stat = con.createStatement();
            rs = stat.executeQuery(sql);
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet getGuides() {
        try {
            ResultSet rs;
            String sql = "SELECT * FROM guide JOIN user JOIN role\n" +
                    "ON guide.userId = user.id AND user.roleId = role.id\n" +
                    "ORDER BY DATE DESC;";
            Statement stat = con.createStatement();
            rs = stat.executeQuery(sql);
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet getGuide(String id) {
        try {
            ResultSet rs;
            String sql = "SELECT * FROM guide JOIN user JOIN role\n" +
                    "ON guide.userId = user.id AND user.roleId = role.id\n" +
                    "WHERE guide.id = " + id +
                    "\nORDER BY DATE DESC;";
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

}
