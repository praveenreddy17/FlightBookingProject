package com.cogjava.security.service;

import com.cogjava.security.model.User;
import com.cogjava.security.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User student) {
        return userRepository.save(student);
    }

    public User getDetails(String username) {
        return userRepository.findBySname(username);
    }

    public String getStudentRoles(String username) {
        return userRepository.findBySname(username).getSrole();
    }
}
