package com.angelsofdeath.profile.service;

import com.angelsofdeath.profile.repository.ProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    ProfileRepository profileRepository = new ProfileRepository();

    public void updateProfile(String uId, String password, String nickname, String comment) {
        profileRepository.updateProfile(uId, password, nickname, comment);
    }
}
