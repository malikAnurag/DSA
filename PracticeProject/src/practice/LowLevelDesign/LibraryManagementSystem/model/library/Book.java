package practice.LowLevelDesign.LibraryManagementSystem.model.library;

import practice.LowLevelDesign.LibraryManagementSystem.enums.BookType;

import java.util.List;

public class Book { // There can be multiple copies of each book which would be referred to as BookItems

    private String uniqueIdNumber;
    private String title;
    private List<Author> authors;
    private BookType bookType;

}
