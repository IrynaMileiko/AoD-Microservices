package com.angelsofdeath.guide.service;

import com.angelsofdeath.guide.entity.Guide;
import com.angelsofdeath.guide.repository.GuideRepository;
import org.springframework.stereotype.Service;

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
}
