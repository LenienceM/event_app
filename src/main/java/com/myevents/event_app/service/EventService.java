package com.myevents.event_app.service;

import com.myevents.event_app.entity.Event;
import com.myevents.event_app.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(int id) {
        return eventRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Event not found"));
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(int id, Event event) {
        Event existing = getEventById(id);
        existing.setName(event.getName());
        existing.setEventYear(event.getEventYear());
        return eventRepository.save(existing);
    }

    public void deleteEvent(int id) {
        eventRepository.deleteById(id);
    }

}