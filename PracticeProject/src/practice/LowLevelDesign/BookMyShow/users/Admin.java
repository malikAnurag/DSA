package practice.LowLevelDesign.BookMyShow.users;

import practice.LowLevelDesign.BookMyShow.model.Movie;
import practice.LowLevelDesign.BookMyShow.model.Show;

public class Admin extends SystemMember {

    public boolean addMovie(Movie movie) {return true;}
    public boolean addShow(Show show) {return false;}

}
