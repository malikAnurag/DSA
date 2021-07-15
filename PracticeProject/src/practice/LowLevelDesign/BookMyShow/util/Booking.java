package practice.LowLevelDesign.BookMyShow.util;

import practice.LowLevelDesign.BookMyShow.model.Audi;
import practice.LowLevelDesign.BookMyShow.model.Seat;
import practice.LowLevelDesign.BookMyShow.model.Show;
import practice.LowLevelDesign.BookMyShow.users.Customer;
import practice.LowLevelDesign.BookMyShow.enums.BookingStatus;

import java.util.Date;
import java.util.List;

public class Booking {

    private String bookingId;
    private Date bookingDate;
    private Customer customer;
    private Show show;
    private Audi audi;
    private BookingStatus bookingStatus;
    private Double amount;
    private List<Seat> seatList;
    private Payment paymentObj;

    public boolean makePayment(Payment payment) {return true;}

}
