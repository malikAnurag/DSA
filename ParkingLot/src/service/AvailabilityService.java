package service;

import java.util.ArrayList;

import domainobject.Vehicle;
import parking.ParkingPlace;
import vehicleConstants.Constants;

public class AvailabilityService {

	public boolean checkAvailability(Vehicle vehicle) {
		
		ArrayList<ParkingPlace> parkingList = Constants.parkingPlaces;
		boolean isAvailable= false;
		if(parkingList.size()<Constants.TOTAL_SPACE) {
			for(ParkingPlace parkingPlace : parkingList) {
				if(vehicle.canFitInPlace(parkingPlace) && parkingPlace.getAvailableplaces() > 0) {
					isAvailable = true;
					break;
				}
			}
		}
		return isAvailable;
	}
}
