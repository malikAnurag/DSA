package practice.LowLevelDesign.HotelBookingSystem.model.users;

import practice.LowLevelDesign.HotelBookingSystem.model.hotel.Room;

import java.util.Date;
import java.util.List;

public class HouseKeeper extends Person {

    // Lists rooms that are serviced by this housekeeper in a given date
    public List<Room> getRoomServiced(Date date) { return null;}
}

