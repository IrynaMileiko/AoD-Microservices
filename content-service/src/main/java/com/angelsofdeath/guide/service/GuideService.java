package com.angelsofdeath.guide.service;

import com.angelsofdeath.guide.entity.Guide;
import com.angelsofdeath.guide.repository.GuideRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class GuideService {
    private GuideRepository guideRepository = new GuideRepository();


    public List<Guide> getAllGuides() {
        return guideRepository.getAllGuides();
    }

    public Guide getGuide(String id) {
        return guideRepository.getGuide(id);
    }

    public boolean isUsersGuide(String chId, String userId) {
        return guideRepository.isUsersGuide(chId, userId);
    }

    public void editGuide(String id, String name, String text, String userId) {
        if (isUsersGuide(id, userId)) {
            guideRepository.editGuide(id, name, text);
        }
    }

    public void addGuide(String userId, String name, String text) {
        Date udate = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH-mm-ss");
        guideRepository.addGuide(userId, name, text, dateFormat.format(udate));
    }

    public void deleteGuide(String id, String userId) {
        if (isUsersGuide(id, userId))
            guideRepository.deleteGuide(id);
    }
}
