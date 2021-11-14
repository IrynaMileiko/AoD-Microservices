package com.angelsofdeath.guide.service;

import com.angelsofdeath.guide.entity.Event;
import com.angelsofdeath.guide.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private EventRepository eventRepository = new EventRepository();

    public List<Event> getAllEvents(){
        return eventRepository.getAllEvents();
    }
}
