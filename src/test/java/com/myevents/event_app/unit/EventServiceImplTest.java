package com.myevents.event_app.unit;

import com.myevents.event_app.entity.Event;
import com.myevents.event_app.repository.EventRepository;
import com.myevents.event_app.service.EventService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventServiceImplTest {

    private final Event event = new Event(0, "test", "2025");
    @Mock
    private EventRepository eventRepository;
    @InjectMocks
    private EventService eventService;

    @Test
    void getAllEvents() {
        List<Event> events = List.of(new Event(1, "Mock Event", "2025"));
        when(eventRepository.findAll()).thenReturn(events);

        List<Event> result = eventService.getAllEvents();
        assertEquals(1, result.size());
        assertEquals("Mock Event", result.getFirst().getName());
    }

    @Test
    void getEventById() {
        when(eventRepository.findById(1)).thenReturn(Optional.of(event));

        Event result = eventService.getEventById(1);
        assertEquals("test", result.getName());
    }

    @Test
    void createEvent() {
        when(eventRepository.save(any(Event.class))).thenReturn(new Event(1, "Create Me", "2025"));

        Event saved = eventService.createEvent(event);
        assertEquals(1, saved.getId());
    }
}
