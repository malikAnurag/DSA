package practice.LowLevelDesign.HotelBookingSystem.model.hotel;

import practice.LowLevelDesign.HotelBookingSystem.enums.RoomStatus;
import practice.LowLevelDesign.HotelBookingSystem.enums.RoomStyle;

import java.util.List;

public class Room {

    private String roomNumber;
    private RoomStyle roomStyle;
    private RoomStatus roomStatus;
    private double bookingPrice;
    private List<RoomKey> roomKeys;
    private List<HouseKeepingLog> houseKeepingLogs;
}
