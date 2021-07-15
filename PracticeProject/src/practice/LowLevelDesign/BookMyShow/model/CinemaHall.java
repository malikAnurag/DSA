package practice.LowLevelDesign.BookMyShow.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class CinemaHall {

    private int cinemaId;
    private String cinemaHallName;
    private Address address;
    private List<Audi> audiList;

    public Map<Date, Movie> getMovies(List<Date> dateList) {return null;}
    public Map<Date, Show> getShows(List<Date> dateList) { return null;}

}
