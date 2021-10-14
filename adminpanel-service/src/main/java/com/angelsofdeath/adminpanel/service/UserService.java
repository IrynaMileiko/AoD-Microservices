package com.angelsofdeath.adminpanel.service;

import com.angelsofdeath.adminpanel.entity.Role;
import com.angelsofdeath.adminpanel.entity.User;
import com.angelsofdeath.adminpanel.repository.DbConnector;
import com.angelsofdeath.adminpanel.repository.RoleRepository;
import com.angelsofdeath.adminpanel.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository = new UserRepository();

    public User getUser(Long userId) {
        return userRepository.getUser(userId);
    }

    public List<User> getAllUsers(String sortColumn, boolean direct, int priority) {
        return userRepository.getAllUsers(sortColumn, direct, priority);
    }
}
