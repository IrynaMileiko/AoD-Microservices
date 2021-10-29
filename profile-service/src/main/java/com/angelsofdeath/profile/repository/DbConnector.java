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

    public void deleteCharacter(String chId) {
        try {
            String sql = "DELETE FROM gamechar WHERE id = \"" + chId + "\"";
            Statement stat = con.createStatement();
            stat.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet getChUs(String chId, String userId) {
        try {
            ResultSet rs;
            String sql = "SELECT * FROM user JOIN gamechar\n" +
                    "ON gamechar.userId = user.id\n" +
                    "    WHERE user.id=\"" + userId + "\" AND " +
                    "       gamechar.id=\"" + chId + "\"";
            Statement stat = con.createStatement();
            rs = stat.executeQuery(sql);
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet getCharByNameId(String name, String chId) {
        try {
            ResultSet rs;
            String sql = "SELECT * FROM gamechar\n" +
                    "    WHERE name=\"" + name + "\" AND id!=\"" + chId + "\"";
            Statement stat = con.createStatement();
            rs = stat.executeQuery(sql);
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void editCharacter(String chId, String name, String classId, String descr) {
        try {
            String sql = "" +
                    "UPDATE gamechar SET " +
                    "name = \"" + name + "\", " +
                    "classId = \"" + classId + "\", " +
                    "description = \"" + descr + "\" " +
                    "WHERE id = \"" + chId + "\"";
            Statement stat = con.createStatement();
            stat.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
