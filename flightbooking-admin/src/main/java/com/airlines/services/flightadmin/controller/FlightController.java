package com.airlines.services.flightadmin.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.airlines.services.flightadmin.entity.FlightDetails;
import com.airlines.services.flightadmin.entity.UserDetails;
import com.airlines.services.flightadmin.serviceimpl.FlightServiceImpl;
@RestController
@RequestMapping("/flight")
@CrossOrigin(origins="*")
public class FlightController {
	
	@Autowired
    private FlightServiceImpl service;
	@PostMapping("/addflight")
	public String addflight(@RequestBody FlightDetails details ) {	
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   details.setCreatedDate(dtf.format(now));
		   service.save(details);
		return "Flight added successfully";		
		
	}
	@GetMapping("/getAllFlights")
	public List<FlightDetails> getAllFlights() {
		return service.findAll();
	}		

	@DeleteMapping("/deleteFlight/{id}")
	public String deleteFlight(@PathVariable int id) {
		service.deleteById(id);
		return " Flight Deleted Successfully";
	}
	@PostMapping("/updateFlight")
	public String updateFlight(@RequestBody FlightDetails details) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   details.setCreatedDate(dtf.format(now));
		   service.save(details);
		   return "Flight updated successfully" ;		
	}
	@PostMapping("/addUser")
	public String addUser(@RequestBody UserDetails details ) {	
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   details.setCreatedDate(dtf.format(now));
		   service.saveUser(details);
		return "Flight added successfully";		
		
	}
	
}
