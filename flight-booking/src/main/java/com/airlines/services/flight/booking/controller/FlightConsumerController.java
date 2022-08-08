package com.airlines.services.flight.booking.controller;

import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airlines.services.flight.booking.user.entity.FlightDetails;
import com.airlines.services.flight.booking.user.entity.User;
import com.airlines.services.flight.booking.user.entity.UserBookings;
import com.airlines.services.flight.booking.user.repository.UserRepository;
import com.airlines.services.flight.booking.user.service.UserService;

@RestController
@RequestMapping("/user")
public class FlightConsumerController {

	
	@Autowired
	private UserRepository userRepository;	
	@Autowired
	private UserService userService;	
	Random rnd = new Random();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	Calendar cal = Calendar.getInstance();  
	String today=sdf.format(cal.getTime());
	
	@GetMapping("/getUserFlights/{id}")
	public List<UserBookings> getUserFlights(@PathVariable("id") String ID){
		List<UserBookings> readAirLines = userRepository.getUserFlights(ID);
		for(UserBookings flightDto:readAirLines) {
			System.out.println(flightDto.getFlightID());
		}
		return readAirLines;
	}
	@GetMapping("/bookFlight")
	public String bookFlight(@RequestBody FlightDetails fDetails){		
						 
		    Random rnd = new Random();
		    Long number = (long) rnd.nextInt(99999999);
			UserBookings booking= new UserBookings();
			booking.setFlightID(fDetails.getFlightID());			
			User user=userService.getUser(fDetails.getUserName());
			booking.setUserID(user.getUserID());
			booking.setJourneyDate(fDetails.getDate());
			booking.setCreatedDate( today);
			booking.setPNR("PNR-"+number);
			booking.setCreatedBy(user.getUserName());
			booking.setFromPlace(fDetails.getFromPlace());
			booking.setToPlace(fDetails.getToPlace());
			booking.setUserName(user.getUserName());
			booking.setCost(String.valueOf(fDetails.getCost()* Integer.valueOf(fDetails.getNoOfPassengers())));
			booking.setIsActive("Y");
			 userRepository.bookFlight(booking);
		
		
		
		return "Your Flight has been booked Successfully ";
	}
	
	
}
