package service;

import java.util.List;

import dao.TripDao;
import dao.TripDaoImpl;
import entities.Trip;

public class TripServiceImpl implements TripService {
	private final  TripDao dao;
	public TripServiceImpl() {
		dao =new TripDaoImpl();
	}
	@Override
	public List<Trip> getAllTrips() {
		return dao.getAllTrips();
	}

	@Override
	public void deleteTrip(Trip trip) {
		deleteTrip(trip);
	}
	@Override
	public void addTrip(Trip trip) {
		dao.addTrip(trip);	
	}

}
