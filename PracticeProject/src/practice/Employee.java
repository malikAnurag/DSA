package practice;

import java.util.Date;

/**
 * Fields are: Intger Id, String name, Date doj;
 */
public final class Employee {

    private final Integer id;
    private final String name;
    private final Date date;

    public Employee(Integer id, String name, Date date) {
        this.id = id;
        this.name = name;
        Date dateCopy = new Date();
        dateCopy.setDate(date.getDate());
        this.date = dateCopy;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        Date dateCopy = new Date();
        dateCopy.setDate(date.getDate());
        return dateCopy;
    }
}
