package practice.LowLevelDesign.HotelBookingSystem.model.hotel;

import java.util.Date;

public class RoomKey {

    private String keyId;
    private String barCode;
    private Date issuedAt;
    private boolean isActive;
    private boolean isMaster;

    // Whenever we initialize a room key object, we will assign this key to a particular room
    // This will use this room key object and will add it in the roomKeys list that is associated with every room
    public void assignRoom(Room room) {}
}
