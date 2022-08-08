package com.airlines.services.flightadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airlines.services.flightadmin.entity.FlightDetails;
import com.airlines.services.flightadmin.entity.UserDetails;

public interface FlightRepository extends JpaRepository<FlightDetails,Integer> {

}


