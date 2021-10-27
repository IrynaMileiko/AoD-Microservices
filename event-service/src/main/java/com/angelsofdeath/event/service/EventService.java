package com.angelsofdeath.event.service;

import com.angelsofdeath.event.entity.Event;
import com.angelsofdeath.event.repository.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class EventService {
    private EventRepository eventRepository = new EventRepository();

    public List<Event> getAllEvents(){
        return eventRepository.getAllEvents();
    }
}
