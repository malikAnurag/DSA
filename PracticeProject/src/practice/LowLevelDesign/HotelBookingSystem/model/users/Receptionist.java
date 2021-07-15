package practice.LowLevelDesign.HotelBookingSystem.model.users;

import practice.LowLevelDesign.HotelBookingSystem.util.Booking;
import practice.LowLevelDesign.HotelBookingSystem.util.RoomBooking;
import practice.LowLevelDesign.HotelBookingSystem.util.Search;

public class Receptionist extends Person {

    private Search searchObj;
    private Booking bookingObj;

    public void checkInGuest(Guest guest, RoomBooking roomBookingInfo){}
    public void checkOutGuest(Guest guest, RoomBooking roomBookingInfo){}
}
