package service;

import java.util.List;

import entities.Trip;

public interface TripService {
	List<Trip> getAllTrips();
	void deleteTrip(Trip trip);
	void addTrip(Trip trip);
}
