package practice.LowLevelDesign.HotelBookingSystem.charges;

public class InRoomPurchaseCharge implements BaseRoomCharge {

    private double cost;
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
