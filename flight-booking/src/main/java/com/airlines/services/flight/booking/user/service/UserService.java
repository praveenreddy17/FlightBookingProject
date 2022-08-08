package com.airlines.services.flight.booking.user.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.airlines.services.flight.booking.user.entity.FlightDetails;
import com.airlines.services.flight.booking.user.entity.User;

public interface UserService {

	public ResponseEntity<User> createUser(User newUser);

	public User updateUser(User newUser) ;

	public String deleteUser(int Id) ;

	public User getUser(int id);

	public ResponseEntity<String> signIn(User user);

	public List<FlightDetails> searchFlights(FlightDetails newUser);

	public User getUser(String userName);

	public void deleteUserFlight(int id);

}