package practice.LowLevelDesign.LibraryManagementSystem.util;

import practice.LowLevelDesign.LibraryManagementSystem.model.library.BookItem;
import practice.LowLevelDesign.LibraryManagementSystem.model.users.SystemUser;

public class BookIssueService {

    // to calculate any late fee applicable on the book
    private FineService fineService;

    // Before issuing any book, we'll call this to check while we try renew/issue functions on the book
    // First we have to see whether this particular book is reserved by anyone or not
    // If it has been reserved by someone, then we will notify that person. If not, then only we will allow this person to renew/issue the book.
    public BookReservationDetail getReservationDetail(BookItem bookItem) {return null;}

    public void updateReservationDetail(BookReservationDetail bookReservationDetail) {}

    public BookReservationDetail reserveBook(BookItem bookItem, SystemUser user) {return null;}

    // Check reservation detail before issuing
    public BookIssueDetail issueBook(BookItem bookItem, SystemUser user) {return null;}

    // Check reservation detail before renewing
    // This will internally call the issueBook function after basic validations
    public BookIssueDetail renewBook(BookItem bookItem, SystemUser user) {return null;}

    public void returnBook(BookItem bookItem, SystemUser user) {}
}
