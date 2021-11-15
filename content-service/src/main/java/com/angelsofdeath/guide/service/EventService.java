package com.angelsofdeath.guide.service;

import com.angelsofdeath.guide.entity.Event;
import com.angelsofdeath.guide.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EventService {
    private EventRepository eventRepository = new EventRepository();

    public List<Event> getAllEvents() {
        return eventRepository.getAllEvents();
    }

    public Event getEvent(String id) {
        return eventRepository.getEvent(id);
    }

    public boolean isUsersEvent(String chId, String userId) {
        return eventRepository.isUsersEvent(chId, userId);
    }

    public void editEvent(String id, String name, String text, String userId, String datetime) {
        if (isUsersEvent(id, userId))
            eventRepository.editEvent(id, name, text, datetime);
    }

    public void addEvent(String userId, String name, String text, String datetime) {
        eventRepository.addEvent(userId, name, text, datetime);
    }

    public void deleteEvent(String id, String userId) {
        if (isUsersEvent(id, userId))
            eventRepository.deleteGuide(id);
    }
}
