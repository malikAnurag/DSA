package practice.LowLevelDesign.BookMyShow.model;

import practice.LowLevelDesign.BookMyShow.enums.Genre;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Movie {

    private int movieId;
    private Genre genre;
    private String movieName;
    private String language;
    private Date releaseDate;
    private int durationInMins;

    private Map<String, List<Show>> cityShowMap;

}
