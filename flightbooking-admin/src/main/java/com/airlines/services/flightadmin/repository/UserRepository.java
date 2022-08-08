package com.airlines.services.flightadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airlines.services.flightadmin.entity.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails,Integer>{

}
