package com.airlines.services.flight.booking.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_BOOKINGS")
public class UserBookings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	@Column
	private String UserName;
	@Column
	private int UserID;
	@Column
	private int FlightID;
	@Column
	private String JourneyDate;
	@Column
    private String CreatedDate;
	@Column
    private String CreatedBy;
	@Column
    private String PNR;
	@Column
    private String PassengersCount;
	@Column
    private String Cost;
	
	@Column
    private String IsActive;
	@Column
    private String FromPlace;
	@Column
    private String ToPlace;
	
	
	
	public String getFromPlace() {
		return FromPlace;
	}
	public void setFromPlace(String fromPlace) {
		FromPlace = fromPlace;
	}
	public String getToPlace() {
		return ToPlace;
	}
	public void setToPlace(String toPlace) {
		ToPlace = toPlace;
	}
	public String getPassengersCount() {
		return PassengersCount;
	}
	public void setPassengersCount(String passengersCount) {
		PassengersCount = passengersCount;
	}
	public String getCost() {
		return Cost;
	}
	public void setCost(String cost) {
		Cost = cost;
	}
	public String getPNR() {
		return PNR;
	}
	public void setPNR(String pNR) {
		PNR = pNR;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getFlightID() {
		return FlightID;
	}
	public void setFlightID(int flightID) {
		FlightID = flightID;
	}
	public String getJourneyDate() {
		return JourneyDate;
	}
	public void setJourneyDate(String journeyDate) {
		JourneyDate = journeyDate;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(String createdDate) {
		CreatedDate = createdDate;
	}
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}
	public String getIsActive() {
		return IsActive;
	}
	public void setIsActive(String isActive) {
		IsActive = isActive;
	}
	
	
	

    
}