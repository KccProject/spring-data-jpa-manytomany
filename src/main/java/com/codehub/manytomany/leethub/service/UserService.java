package com.codehub.manytomany.leethub.service;

import org.springframework.stereotype.Service;

import com.codehub.manytomany.leethub.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
