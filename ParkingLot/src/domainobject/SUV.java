package domainobject;

import parking.ParkingPlace;
import vehicleConstants.VehicleSize;

public class SUV extends Vehicle {

	public SUV(String vehicleNumber) {
		size = VehicleSize.LARGE;
		Id = vehicleNumber;
	}

	@Override
	public boolean canFitInPlace(ParkingPlace parkingPlace) {
		return parkingPlace.getVehicleSize().equals(size);
	}
}
