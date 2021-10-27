package com.angelsofdeath.guide.controller;

import com.angelsofdeath.guide.entity.Guide;
import com.angelsofdeath.guide.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/guides")
public class GuideController {
    @Autowired
    GuideService guideService;

    @GetMapping("/all")
    public List<Guide> getAllGuides() {
        return guideService.getAllGuides();
    }
}
