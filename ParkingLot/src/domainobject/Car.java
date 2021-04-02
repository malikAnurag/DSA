package domainobject;

import parking.ParkingPlace;
import vehicleConstants.VehicleSize;

public class Car extends Vehicle {

	public Car(String vehicleNumber) {
		size = VehicleSize.MEDIUM;
		Id = vehicleNumber;
	}

	@Override
	public boolean canFitInPlace(ParkingPlace parkingPlace) {
		return parkingPlace.getVehicleSize().equals(size);
	}

}
