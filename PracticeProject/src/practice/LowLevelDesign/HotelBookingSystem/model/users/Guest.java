package practice.LowLevelDesign.HotelBookingSystem.model.users;

import practice.LowLevelDesign.HotelBookingSystem.util.Booking;
import practice.LowLevelDesign.HotelBookingSystem.util.RoomBooking;
import practice.LowLevelDesign.HotelBookingSystem.util.Search;

import java.util.List;

public class Guest extends Person {

    // As per the design, both the guest and the receptionist should have access to functions that can be performed on rooms like search, book, etc
    private Search searchObj;
    private Booking bookingObj;

    public List<RoomBooking> getAllRoomBookings() {return null;}
}
