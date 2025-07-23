package com.myevents.event_app.repository;

import com.myevents.event_app.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {

}