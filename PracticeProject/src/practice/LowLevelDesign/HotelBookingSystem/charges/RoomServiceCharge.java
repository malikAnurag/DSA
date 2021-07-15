package practice.LowLevelDesign.HotelBookingSystem.charges;

public class RoomServiceCharge implements BaseRoomCharge {

    private double cost;

    // whenever a room service is taken, whatever cost this has, it will add to the cost of the room and will return it
    // we are decorating the room cost every time some service is taken in that room
    private BaseRoomCharge baseRoomCharge;

    @Override
    public Double getCost() {
        baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
        return baseRoomCharge.getCost();
    }

    @Override
    public void setCost(double cost) {
        this.cost = cost;
    }
}
