package service;

import static vehicleConstants.Constants.BIKE_SPACE;
import static vehicleConstants.Constants.CAR_SPACE;
import static vehicleConstants.Constants.SUV_SPACE;

import java.util.ArrayList;

import domainobject.Vehicle;
import parking.ParkingPlace;
import vehicleConstants.Constants;
import vehicleConstants.VehicleSize;

public class AllocationService {

	public boolean allocateSpace(Vehicle vehicle) {

		ArrayList<ParkingPlace> parkingList = Constants.parkingPlaces;
		boolean isAllocated = false;
		if (parkingList.size() < Constants.TOTAL_SPACE) {
			for (ParkingPlace parkingPlace : parkingList) {
				if (vehicle.canFitInPlace(parkingPlace) && parkingPlace.getAvailableplaces() > 0) {
					ParkingPlace newParking = new ParkingPlace(vehicle.getSize());
					vehicle.setParkingPlace(newParking);
					decrementAvailableSpace(vehicle);
					parkingList.add(newParking);
					isAllocated = true;
				}
			}
		}
		return isAllocated;

	}

	public void decrementAvailableSpace(Vehicle vehicle) {

		if (VehicleSize.SMALL.equals(vehicle.getSize())) {
			BIKE_SPACE -= 1;
		} else if (VehicleSize.MEDIUM.equals(vehicle.getSize())) {
			CAR_SPACE -= 1;
		} else {
			SUV_SPACE -= 1;
		}

	}
}
