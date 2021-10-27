package com.angelsofdeath.authorization.service;

import com.angelsofdeath.authorization.entity.LUCheck;
import com.angelsofdeath.authorization.entity.User;
import com.angelsofdeath.authorization.repository.AuthorizationRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {
    private AuthorizationRepository authorizationRepository = new AuthorizationRepository();


    public User getUser(String login, String password) {
        return authorizationRepository.getUser(login, password);
    }

    public User addUser(String username, String login, String password) {
        return authorizationRepository.addUser(username, login, password);
    }

    public Boolean getUserByLogin(String login) {
        return authorizationRepository.getUserByLogin(login);
    }

    public Boolean getUserByUsername(String username) {
        return authorizationRepository.getUserByUsername(username);
    }

    public LUCheck getByLU(String login, String username) {
        return authorizationRepository.getUserByLU(login, username);
    }
}
