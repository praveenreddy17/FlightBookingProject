package com.airlines.services.flight.booking.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.airlines.services.flight.booking.user.entity.User;
import com.airlines.services.flight.booking.user.entity.UserBookings;

@Service
public interface UserRepository{

	 public List<UserBookings> getUserFlights(String iD);
	 public User getUser(int id);
	public void bookFlight(UserBookings booking);

	
}