package com.cogjava.security.controller;

import com.cogjava.security.model.User;
import com.cogjava.security.service.UserService;
import com.cogjava.security.util.JwtTokenCreator;
import com.cogjava.security.util.JwtTokenValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService service;

    private PasswordEncoder encoder;

    public UserController(UserService service, PasswordEncoder encoder) {
        this.service = service;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public User registerStudent(@RequestBody User student) {
        User student1 = new User();
        logger.info("Student name: {}", student.getSname());
        student1.setSname(student.getSname());
        student1.setPassword(encoder.encode(student.getPassword()));
        student1.setSrole(student.getSrole());
        return service.register(student1);
    }
    
    @PostMapping("/login")
    public String login(){
        return "Successfully logged in by user: "+SecurityContextHolder.getContext().getAuthentication().getName();
    }

    
    @GetMapping("/userInfo")
    public User getStudentInfo(@RequestParam("sname") String username) {
        return service.getDetails(username);
    }

    
    @GetMapping("/getUserRoles")
    public String getStudentRoles(@RequestParam("sname") String username) {
        return service.getStudentRoles(username);
    }

   
    @GetMapping("/refreshToken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {
        logger.info("Inside refresh token...");
        JwtTokenCreator generator = new JwtTokenCreator();
        JwtTokenValidator validation = new JwtTokenValidator();
        validation.validateJwtToken(request, response, true);
        generator.generateToken(request, response);
    }

}
