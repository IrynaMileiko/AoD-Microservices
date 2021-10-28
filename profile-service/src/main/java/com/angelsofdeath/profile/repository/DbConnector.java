package com.angelsofdeath.profile.repository;

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

    public void deleteUser(String uId) {
        try {
            String sql = "DELETE FROM user WHERE id=" + uId;
            Statement stat = con.createStatement();
            stat.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet getCharacter(String id) {
        try {
            ResultSet rs;
            String sql = "SELECT * FROM charclass JOIN gamechar\n" +
                    "ON gamechar.classId=charclass.id\n" +
                    "    WHERE gamechar.id=" + id;
            Statement stat = con.createStatement();
            rs = stat.executeQuery(sql);
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet getUserCharacters(String id) {
        try {
            ResultSet rs;
            String sql = "SELECT * FROM charclass JOIN gamechar\n" +
                    "ON gamechar.classId=charclass.id\n" +
                    "    WHERE userId=" + id;
            Statement stat = con.createStatement();
            rs = stat.executeQuery(sql);
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void updateProfile(String uId, String password, String nickname, String comment) {
        try {
            String sql = "UPDATE user set password=\"" + password + "\", nickname=\"" + nickname +
                    "\", comment=\"" + comment + "\" WHERE id=" + uId;
            Statement stat = con.createStatement();
            stat.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet getAllClasses() {
        try {
            ResultSet rs;
            String sql = "SELECT * FROM charclass\n";
            Statement stat = con.createStatement();
            rs = stat.executeQuery(sql);
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet getCharByName(String name) {
        try {
            ResultSet rs;
            String sql = "SELECT * FROM charclass JOIN gamechar\n" +
                    "ON gamechar.classId=charclass.id\n" +
                    "    WHERE gamechar.name=\"" + name + "\"";
            Statement stat = con.createStatement();
            rs = stat.executeQuery(sql);
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void addCharacter(String name, String classId, String descr, String userId) {
        try {
            String sql = "Insert into gamechar (name, classId, userId, description) " +
                    "VALUES(" +
                    "\"" + name + "\", " +
                    "\"" + classId + "\", " +
                    "\"" + userId + "\", " +
                    "\"" + descr + "\"" +
                    ")";
            Statement stat = con.createStatement();
            stat.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
