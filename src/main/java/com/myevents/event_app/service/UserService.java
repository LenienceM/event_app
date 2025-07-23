package com.myevents.event_app.service;

import com.myevents.event_app.entity.User;
import com.myevents.event_app.repository.UserRepository;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public User findByEmail(String email) {
        return userRepository.findByUsername(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


}
