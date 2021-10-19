package com.angelsofdeath.profile.controller;

import com.angelsofdeath.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @PostMapping("/update")
    public void updateProfile(@RequestParam String uId, @RequestParam String password,
                              @RequestParam String nickname, @RequestParam String comment) {
        profileService.updateProfile(uId, password, nickname, comment);
    }
}
