package practice.LowLevelDesign.HotelBookingSystem.charges;

/*  Decorator Pattern is used to decorate the prices */

public interface BaseRoomCharge {

    Double getCost();

    void setCost(double cost);

}
