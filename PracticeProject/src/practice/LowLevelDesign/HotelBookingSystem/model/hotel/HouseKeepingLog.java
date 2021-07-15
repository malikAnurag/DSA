package practice.LowLevelDesign.HotelBookingSystem.model.hotel;

import practice.LowLevelDesign.HotelBookingSystem.model.users.HouseKeeper;

import java.util.Date;

public class HouseKeepingLog {

    private String description;
    private Date startDate;
    private int duration;
    private HouseKeeper houseKeeper;

    // Used to add this particular housekeepingLog to the list that is present inside a room similar to the room key
    public void addRoom(Room room) {}
}
