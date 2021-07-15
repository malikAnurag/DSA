package practice.LowLevelDesign.LibraryManagementSystem.model.library;

import practice.LowLevelDesign.LibraryManagementSystem.model.users.Person;

import java.util.List;

/**
 * This contains a list of books that the author has published and this will help in fulfilling the requirement of search if user searches a book by author name.
 */
public class Author extends Person {

    private List<Book> booksPublished;

}
