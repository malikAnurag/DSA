package service;

import static vehicleConstants.Constants.BIKE_SPACE;
import static vehicleConstants.Constants.CAR_SPACE;
import static vehicleConstants.Constants.SUV_SPACE;

import java.util.ArrayList;
import domainobject.Vehicle;
import parking.ParkingPlace;
import vehicleConstants.Constants;
import vehicleConstants.VehicleSize;

public class RemovalService {

	public void vacateParking(Vehicle vehicle) {

		ArrayList<ParkingPlace> parkingList = Constants.parkingPlaces;

		ParkingPlace parkingPlace = vehicle.getParkingPlace();
		parkingPlace.setAvailableplaces(parkingPlace.getAvailableplaces() + 1);
		incrementAvailableSpace(vehicle);
		parkingList.remove(parkingPlace);

	}

	public void incrementAvailableSpace(Vehicle vehicle) {
		if (VehicleSize.SMALL.equals(vehicle.getSize())) {
			BIKE_SPACE += 1;
		} else if (VehicleSize.MEDIUM.equals(vehicle.getSize())) {
			CAR_SPACE += 1;
		} else {
			SUV_SPACE += 1;
		}
	}
}
