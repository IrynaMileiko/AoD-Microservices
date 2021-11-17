package com.angelsofdeath.services.controller;

import com.angelsofdeath.services.entity.Event;
import com.angelsofdeath.services.entity.NewEvent;
import com.angelsofdeath.services.entity.NewGuide;
import com.angelsofdeath.services.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Event getEvent(@PathVariable String id) {
        return eventService.getEvent(id);
    }

    @PostMapping("/edit/{id}")
    public void editEvent(@PathVariable String id, @RequestBody NewEvent ch) {
        eventService.editEvent(id, ch.getName(), ch.getText(), ch.getUserId(), ch.getDatetime());
    }

    @PostMapping("/add")
    public void addEvent(@RequestBody NewEvent ch){
        eventService.addEvent(ch.getUserId(),ch.getName(),ch.getText(), ch.getDatetime());
    }

    @PostMapping("/delete/{id}")
    public void deleteEvent(@PathVariable String id, @RequestBody NewGuide ch) {
        eventService.deleteEvent(id, ch.getUserId());
    }
}
