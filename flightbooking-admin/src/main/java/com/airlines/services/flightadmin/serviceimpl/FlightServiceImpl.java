package com.airlines.services.flightadmin.serviceimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airlines.services.flightadmin.entity.FlightDetails;
import com.airlines.services.flightadmin.entity.UserDetails;
import com.airlines.services.flightadmin.repository.FlightRepository;
import com.airlines.services.flightadmin.repository.UserRepository;
@Service
public class FlightServiceImpl {
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	private static List<FlightDetails> flights = new ArrayList<>();

	private static int flightCount = 0;

	public List<FlightDetails> findAll() {
		return flightRepo.findAll();
	}

	public FlightDetails save(FlightDetails flight) {
		flightRepo.save(flight);
		//flights.add(flight);
		return flight;
	}

	public FlightDetails findOne(int id) {
		for (FlightDetails flight : flights) {
			if (flight.getFlightID() == id) {
				return flight;
			}
		}
		return null;
	}

	public void deleteById(int id) {
		flightRepo.deleteById(id);
	}
	public UserDetails saveUser(UserDetails userDetails) {
		userRepo.save(userDetails);
		//flights.add(flight);
		return userDetails;
	}

}
