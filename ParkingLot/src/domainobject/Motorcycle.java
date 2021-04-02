package domainobject;

import parking.ParkingPlace;
import vehicleConstants.VehicleSize;

public class Motorcycle extends Vehicle {

	
	public Motorcycle(String vehicleNumber) {
		size = VehicleSize.SMALL;
		Id = vehicleNumber;
	}

	@Override
	public boolean canFitInPlace(ParkingPlace parkingPlace) {
		return parkingPlace.getVehicleSize().equals(size);
	}
}
