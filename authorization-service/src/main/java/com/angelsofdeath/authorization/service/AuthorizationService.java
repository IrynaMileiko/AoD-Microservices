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
        return authorizationRepository.getUserByLogin(login, "-1");
    }

    public Boolean getUserByUsername(String username) {
        return authorizationRepository.getUserByUsername(username, "-1");
    }

    public LUCheck getByLU(String login, String username, String userID) {
        return authorizationRepository.getUserByLU(login, username, userID);
    }

    public Boolean getUserByUserIdPassword(String uId, String password) {
        return authorizationRepository.getUserByUserIdPassword(uId, password);
    }
}
