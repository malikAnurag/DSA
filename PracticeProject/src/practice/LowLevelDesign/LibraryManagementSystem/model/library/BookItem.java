package practice.LowLevelDesign.LibraryManagementSystem.model.library;

import practice.LowLevelDesign.LibraryManagementSystem.enums.BookFormat;
import practice.LowLevelDesign.LibraryManagementSystem.enums.BookStatus;

import java.util.Date;

public class BookItem extends Book{

    private String barcode; // This will be different for different copies of the same book
    private Date publicationDate;
    private Rack rackLocation;
    private BookStatus bookStatus;
    private BookFormat bookFormat;
    private Date issueDate;

}
