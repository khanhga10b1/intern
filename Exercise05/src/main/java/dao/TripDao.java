package dao;

import java.util.List;

import entities.Trip;

public interface TripDao {
	List<Trip> getAllTrips();
	void addTrip(Trip trip);
	void deleteTrip(Trip trip);
}
