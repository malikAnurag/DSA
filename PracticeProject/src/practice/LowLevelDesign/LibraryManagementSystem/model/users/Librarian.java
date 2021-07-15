package practice.LowLevelDesign.LibraryManagementSystem.model.users;

import practice.LowLevelDesign.LibraryManagementSystem.model.library.BookItem;
import practice.LowLevelDesign.LibraryManagementSystem.util.BookIssueService;
import practice.LowLevelDesign.LibraryManagementSystem.util.Search;

public class Librarian {

    private Search search;
    private BookIssueService bookIssueService;

    public void addBookItem(BookItem bookItem) {}

    public BookItem editBookItem(BookItem bookItem) {return null;}

    public BookItem deleteBookItem(String barCode) {return null;}

}
