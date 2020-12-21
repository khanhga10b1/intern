package entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class Trip {
	private String id;
	private String tripName;
	private String startPlace;
	private String endPlace;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Double price;
	private Integer slot;

	public Trip() {

	}

	public Trip(String id, String tripName, String startPlace, String endPlace, LocalDateTime startTime,
			LocalDateTime endTime, Double price, Integer slot) {
		this.id = id;
		this.tripName = tripName;
		this.startPlace = startPlace;
		this.endPlace = endPlace;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
		this.slot = slot;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTripName() {
		return tripName;
	}

	public void setTripName(String tripName) {
		this.tripName = tripName;
	}

	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getEndPlace() {
		return endPlace;
	}

	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getSlot() {
		return slot;
	}

	public void setSlot(Integer slot) {
		this.slot = slot;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Trip)) {
			return false;
		}
		Trip that = (Trip) o;
		return Objects.equals(getId(), that.getId()) 
				&& Objects.equals(getPrice(), that.getPrice())
				&& Objects.equals(getTripName(), that.getTripName())
				&& Objects.equals(getStartTime(), that.getStartTime())
				&& Objects.equals(getEndTime(), that.getEndTime())
				&& Objects.equals(getStartPlace(), that.getStartPlace())
				&& Objects.equals(getEndPlace(), that.getEndPlace()) 
				&& Objects.equals(getSlot(), that.getSlot());
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tripName, startPlace, endPlace, startTime, endTime, price, slot);
	}

	@Override
	public String toString() {
		return "Chuyến xe " + tripName + " từ " + startPlace + " đến " + endPlace + ", khởi hành lúc: "
				+ startTime.toLocalDate() + " " + startTime.toLocalTime();
	}

}
