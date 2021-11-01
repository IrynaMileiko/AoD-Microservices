package com.angelsofdeath.chattingservice.repository;

import com.angelsofdeath.chattingservice.entity.Message;
import com.angelsofdeath.chattingservice.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MessageRepository {
    private DbConnector connector = new DbConnector();
    private RoleRepository roleRepository = new RoleRepository();

    public List<Message> getMessages() {
        connector.connect();
        ResultSet rs = connector.getMessages();
        List<Message> messages = new LinkedList<>();
        try {
            while (rs.next()) {
                Message message = new Message();
                message.setId(rs.getLong("message.id"));
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                message.setDateTime(rs.getString("message.datetime"));
                message.setText(rs.getString("message.text"));
                message.setUserId(rs.getLong("message.userId"));

                User user = new User();
                user.setId(rs.getLong("user.id"));
                user.setLogin(rs.getString("user.login"));
                user.setPassword(rs.getString("user.password"));
                user.setRoleId(rs.getLong("user.roleId"));
                user.setNickname(rs.getString("user.nickname"));
                user.setComment(rs.getString("user.comment"));
                user.setRole(roleRepository.getRole(user.getRoleId()));
                message.setUser(user);

                messages.add(message);
            }
        } catch (SQLException e) {

        }
        connector.disconnect();
        return messages;
    }

    public void sendMessage(String userId, String msgTxt, String dateTime) {
        connector.connect();
        connector.sendMessage(userId, msgTxt, dateTime);
        connector.disconnect();
    }
}
