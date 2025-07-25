package com.myevents.event_app.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.myevents.event_app.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>{

    Optional<User> findByUsername(String name );
}
