package com.angelsofdeath.services.repository;

import com.angelsofdeath.services.entity.News;
import com.angelsofdeath.services.entity.Role;
import com.angelsofdeath.services.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class NewsRepository {
    private DbConnector connector = new DbConnector();


    public List<News> getAllNews() {
        connector.connect();
        ResultSet rs = connector.getAllNews();
        List<News> news = new LinkedList<>();
        try {
            while (rs.next()) {
                News news1 = new News();
                news1.setId(rs.getLong("new.id"));
                news1.setUserId(rs.getLong("user.id"));
                news1.setDate(rs.getString("date"));
                news1.setName(rs.getString("new.name"));
                news1.setText(rs.getString("text"));
                news1.setUrl(rs.getString("url"));

                Role role = new Role();
                role.setId(rs.getLong("role.id"));
                role.setName(rs.getString("role.name"));
                role.setPriority(rs.getInt("priority"));

                User user = new User();
                user.setId(rs.getLong("user.id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setRoleId(rs.getLong("roleId"));
                user.setNickname(rs.getString("nickname"));
                user.setComment(rs.getString("comment"));

                user.setRole(role);
                news1.setUser(user);

                news.add(news1);
            }
        } catch (SQLException e) {

        }
        connector.disconnect();
        return news;
    }

    public News getNews(String id) {
        connector.connect();
        ResultSet rs = connector.getNews(id);
        News news = new News();
        try {
            rs.next();
            news.setId(rs.getLong("new.id"));
            news.setUserId(rs.getLong("user.id"));
            news.setDate(rs.getString("date"));
            news.setName(rs.getString("new.name"));
            news.setText(rs.getString("text"));

            Role role = new Role();
            role.setId(rs.getLong("role.id"));
            role.setName(rs.getString("role.name"));
            role.setPriority(rs.getInt("priority"));

            User user = new User();
            user.setId(rs.getLong("user.id"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setRoleId(rs.getLong("roleId"));
            user.setNickname(rs.getString("nickname"));
            user.setComment(rs.getString("comment"));

            user.setRole(role);
            news.setUser(user);

        } catch (SQLException e) {
            return null;
        }
        connector.disconnect();
        return news;
    }

    public boolean isUsersNew(String chId, String userId) {
        connector.connect();
        ResultSet rs = connector.getNUs(chId, userId);
        try {
            if (rs.next()) {
                connector.disconnect();
                return true;
            }
            connector.disconnect();
            return false;
        } catch (SQLException e) {
        }
        connector.disconnect();
        return false;
    }

    public void editNew(String id, String name, String text) {
        connector.connect();
        connector.editNew(id, name, text);
        connector.disconnect();
    }

    public void addNew(String userId, String name, String text, String date) {
        connector.connect();
        connector.addNew(userId,name,text,date);
        connector.disconnect();
    }

    public void deleteNew(String id) {
        connector.connect();
        connector.deleteNew(id);
        connector.disconnect();
    }
}
