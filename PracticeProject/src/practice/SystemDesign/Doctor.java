package practice.SystemDesign;


import java.sql.Timestamp;
import java.util.List;

/**
 * 1. On-boarding new doctors and capturing their consultaion availability for 1 week
 * 2. Booking module : List of available doctors (no filtering except for the available slots)
 * 3. Booking a slot.
 */

public class Doctor {
}


// Doctor, Patient, Slot, Address, Booking
enum SlotStatus {
    AVAILABLE, BOOKED;
}

class Doctor1 {
    int id;
    String name;
    Address1 address; // one-to-one mapping
    //
}

class Address1 {
    int id;
    String addressLine;
    String pincode;
    String city;
    String state;
}

class Patient {
    int id;
    String name;
    String email;
    String contactNumber;
}

class Slot {
    int id;
    Doctor doctor;
    SlotStatus slotStatus;
    Timestamp timestamp;
}

class Booking {
    int bookingId;
    int patientId;
    List<Slot> slots;
}

//current Location

//List<Doctor> getAvailableDoctors(Address address, TypeOfDoctor type);
//List<Slot> getAvailableSlotsForDoctor(Doctor doctor);
//doBooking(Patient patient, List<Slot> slot);