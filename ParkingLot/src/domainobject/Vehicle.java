package domainobject;

import parking.ParkingPlace;
import vehicleConstants.VehicleSize;

public abstract class Vehicle {

	protected VehicleSize size;
	protected String Id;
	protected ParkingPlace parkingPlace;
	
	public abstract boolean canFitInPlace(ParkingPlace parkingPlace);
	
	public ParkingPlace getParkingPlace() {
		return parkingPlace;
	}

	public void setParkingPlace(ParkingPlace parkingPlace) {
		this.parkingPlace = parkingPlace;
	}
	
	public VehicleSize getSize() {
		return size;
	}

	public void setSize(VehicleSize size) {
		this.size = size;
	}
	
}
