package practice.LowLevelDesign.HotelBookingSystem.charges;

/**
 * This class gives the total room charge that is incurred.
 */
public class RoomCharge implements BaseRoomCharge{

    private double cost;

    @Override
    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public Double getCost() {
        return cost;
    }
}
