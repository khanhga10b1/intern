package dao;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Trip;

public class TripDaoImpl implements TripDao {

	private static final Map<String, Trip> tripMap = new HashMap<>();

	static {
		List<Trip> trips = new ArrayList<>();
		trips.add(new Trip("TR01", "hihi", "ĐN", "GL", LocalDateTime.of(2020, Month.DECEMBER, 17, 17, 30),
				LocalDateTime.of(2020, Month.DECEMBER, 12, 19, 30), 150000d, 30));
		trips.add(new Trip("TR02", "haha", "GL", "SG", LocalDateTime.of(2020, Month.DECEMBER, 19, 8, 30),
				LocalDateTime.of(2020, Month.DECEMBER, 12, 19, 30), 200000d, 40));
		tripMap.put(trips.get(0).getId(), trips.get(0));
		tripMap.put(trips.get(1).getId(), trips.get(1));
	}

	@Override
	public List<Trip> getAllTrips() {
		return new ArrayList<Trip>(tripMap.values());
	}

	@Override
	public void deleteTrip(Trip trip) {
		tripMap.remove(trip.getId());
	}

	@Override
	public void addTrip(Trip trip) {
		tripMap.put(trip.getId(), trip);
		
	}



}
