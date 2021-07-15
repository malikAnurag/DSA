package practice.LowLevelDesign.HotelBookingSystem.util;

import practice.LowLevelDesign.HotelBookingSystem.charges.BaseRoomCharge;
import practice.LowLevelDesign.HotelBookingSystem.enums.BookingStatus;
import practice.LowLevelDesign.HotelBookingSystem.model.hotel.Room;
import practice.LowLevelDesign.HotelBookingSystem.model.users.Guest;

import java.util.Date;
import java.util.List;

public class RoomBooking {

    private String bookingId;
    private Date startDate;
    private int durationInDays;
    private BookingStatus bookingStatus;
    private List<Guest> guestList;
    private List<Room> roomList;
    private BaseRoomCharge totalRoomCharges;

}
