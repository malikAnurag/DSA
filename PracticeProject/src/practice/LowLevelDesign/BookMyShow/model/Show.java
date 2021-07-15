package practice.LowLevelDesign.BookMyShow.model;

import java.util.Date;
import java.util.List;

public class Show {

    private int showId;
    private Movie movie;
    private Date startTime;
    private Date endTime;
    private CinemaHall cinemaHall;
    private List<Seat> seats; // This is a part of this class and not audi because the status of each seat will vary with each show and so can be the pricing
}
