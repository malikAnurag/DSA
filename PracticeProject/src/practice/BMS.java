package practice;

import java.sql.Timestamp;
import java.util.List;

public class BMS {
}


/**
 * 1. Movies on the basis of location
 * 2. Theaters on the basis of movies
 * 3. Booking a movie
 * 4.
 */


// User, Movie, Theater, Reservation, Address
enum SeatType {
    NORMAL, BOX, VIP;
}

enum SeatStatus {
    BOOKED,
    VACANT;
}

class Address {
    String city;
    String pincode;
    String state;
    String AddressLine;
}

class Theater {
    int id;
    String theaterName;
    Address address;
    List<Seat> seats; // all available/booked seats in the theater
}

class Movie { // pk in 5 theaters 4 shows in each
    int id;
    int theaterId;
    String language;
    Timestamp dateAndTime;
}

class User {
    int id;
    String name;
    String contactNumber;
    String email;
}

class Reservation {
    int reservationId;
    Timestamp dateAndTime;
    int movieId;
    int totalAmount;
    List<Seat> seats;
}

class Seat {
    int id;
    int seatNumber;
    SeatType type;
    SeatStatus status;
}