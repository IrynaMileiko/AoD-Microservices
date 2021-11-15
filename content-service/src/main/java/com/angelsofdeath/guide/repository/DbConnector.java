package com.angelsofdeath.guide.repository;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    public ResultSet getAllNews() {
        try {
            ResultSet rs;
            String sql = "SELECT * FROM new LEFT JOIN user ON new.userId = user.id" +
                    "\nLEFT JOIN role ON" +
                    " user.roleId = role.id\n" +
                    "ORDER BY DATE DESC;";
            Statement stat = con.createStatement();
            rs = stat.executeQuery(sql);
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet getNews(String id) {
        try {
            ResultSet rs;
            String sql = "SELECT * FROM new JOIN user JOIN role\n" +
                    "ON new.userId = user.id AND user.roleId = role.id\n" +
                    "WHERE new.id = " + id +
                    "\nORDER BY DATE DESC;";
            Statement stat = con.createStatement();
            rs = stat.executeQuery(sql);
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet getGUs(String chId, String userId) {
        try {
            ResultSet rs;
            String sql = "SELECT * FROM user JOIN guide\n" +
                    "ON guide.userId = user.id\n" +
                    "    WHERE user.id=\"" + userId + "\" AND " +
                    "       guide.id=\"" + chId + "\"";
            Statement stat = con.createStatement();
            rs = stat.executeQuery(sql);
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void editGuide(String id, String name, String text) {
        try {
            String sql = "" +
                    "UPDATE guide SET " +
                    "name = ?, " +
                    "text = ? " +
                    "WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, text);
            preparedStatement.setLong(3, Long.parseLong(id));
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addGuide(String userId, String name, String text, String date) {
        try {
            String sql = "INSERT into guide(userId, name, date, text) values (?, ?, ?, ?);";
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, userId);
            stat.setString(2, name);
            stat.setString(3, date);
            stat.setString(4, text);
            stat.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteGuide(String id) {
        try {
            String sql = "" +
                    "DELETE FROM guide " +
                    "WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setLong(1, Long.parseLong(id));
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet getNUs(String chId, String userId) {
        try {
            ResultSet rs;
            String sql = "SELECT * FROM user JOIN new\n" +
                    "ON new.userId = user.id\n" +
                    "    WHERE user.id=\"" + userId + "\" AND " +
                    "       new.id=\"" + chId + "\"";
            Statement stat = con.createStatement();
            rs = stat.executeQuery(sql);
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void editNew(String id, String name, String text) {
        try {
            String sql = "" +
                    "UPDATE new SET " +
                    "name = ?, " +
                    "text = ? " +
                    "WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, text);
            preparedStatement.setLong(3, Long.parseLong(id));
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addNew(String userId, String name, String text, String date) {
        try {
            String sql = "INSERT into new(userId, name, date, text) values (?, ?, ?, ?);";
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, userId);
            stat.setString(2, name);
            stat.setString(3, date);
            stat.setString(4, text);
            stat.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteNew(String id) {
        try {
            String sql = "" +
                    "DELETE FROM new " +
                    "WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setLong(1, Long.parseLong(id));
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet getEvent(String id) {
        try {
            ResultSet rs;
            String sql = "SELECT * FROM event JOIN user JOIN role\n" +
                    "ON event.userId = user.id AND user.roleId = role.id\n" +
                    "WHERE event.id = " + id +
                    "\nORDER BY DATE DESC;";
            Statement stat = con.createStatement();
            rs = stat.executeQuery(sql);
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void editEvent(String id, String name, String text, String date) {
        date = date.replace('T', ' ');
        date+=":00";

        try {
            String sql = "" +
                    "UPDATE event SET " +
                    "name = ?, " +
                    "text = ?, " +
                    "date = ?" +
                    "WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, text);
            preparedStatement.setString(3, date);
            preparedStatement.setLong(4, Long.parseLong(id));
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addEvent(String userId, String name, String text, String date) {
        try {
            String sql = "INSERT into event(userId, name, date, text) values (?, ?, ?, ?);";
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, userId);
            stat.setString(2, name);
            stat.setString(3, date);
            stat.setString(4, text);
            stat.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet getEUs(String chId, String userId) {
        try {
            ResultSet rs;
            String sql = "SELECT * FROM user JOIN event\n" +
                    "ON event.userId = user.id\n" +
                    "    WHERE user.id=\"" + userId + "\" AND " +
                    "       event.id=\"" + chId + "\"";
            Statement stat = con.createStatement();
            rs = stat.executeQuery(sql);
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void deleteEvent(String id) {
        try {
            String sql = "" +
                    "DELETE FROM event " +
                    "WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setLong(1, Long.parseLong(id));
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
