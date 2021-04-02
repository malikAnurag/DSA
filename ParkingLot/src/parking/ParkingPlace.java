package parking;

import domainobject.Vehicle;
import vehicleConstants.VehicleSize;

public class ParkingPlace {

	private Vehicle vehicle;
	private VehicleSize vehicleSize;
	private int placeNumber;
	private int availablePlaces;

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public VehicleSize getVehicleSize() {
		return vehicleSize;
	}

	public void setPlaceSize(VehicleSize vehicleSize) {
		this.vehicleSize = vehicleSize;
	}

	public int getPlaceNumber() {
		return placeNumber;
	}

	public void setPlaceNumber(int placeNumber) {
		this.placeNumber = placeNumber;
	}

	public int getAvailableplaces() {
		return availablePlaces;
	}

	public void setAvailableplaces(int availableplaces) {
		this.availablePlaces = availableplaces;
	}

	public ParkingPlace(VehicleSize vehicleSize) {
		this.vehicleSize = vehicleSize;
	}

	public boolean isAvailable() {
		return vehicle == null;
	}
}
