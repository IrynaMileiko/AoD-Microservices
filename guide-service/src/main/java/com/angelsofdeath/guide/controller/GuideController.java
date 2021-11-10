package com.angelsofdeath.guide.controller;

import com.angelsofdeath.guide.entity.Guide;
import com.angelsofdeath.guide.entity.NewGuide;
import com.angelsofdeath.guide.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Guide getGuide(@PathVariable String id) {
        return guideService.getGuide(id);
    }

    @PostMapping("/edit/{id}")
    public void editGuide(@PathVariable String id, @RequestBody NewGuide ch) {
        guideService.editGuide(id, ch.getName(), ch.getText(), ch.getUserId());
    }

    @PostMapping("/add")
    public void addGuide(@RequestBody NewGuide ch){
        guideService.addGuide(ch.getUserId(),ch.getName(),ch.getText());
    }

    @PostMapping("/delete/{id}")
    public void deleteGuide(@PathVariable String id, @RequestBody NewGuide ch){
        guideService.deleteGuide(id, ch.getUserId());
    }
}

