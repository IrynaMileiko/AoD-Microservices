package com.angelsofdeath.guide.controller;

import com.angelsofdeath.guide.entity.Event;
import com.angelsofdeath.guide.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping("/all")
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }
}
