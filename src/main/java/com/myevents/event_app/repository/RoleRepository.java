package com.myevents.event_app.repository;

import com.myevents.event_app.entity.Event;
import com.myevents.event_app.entity.Role;
import com.myevents.event_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}