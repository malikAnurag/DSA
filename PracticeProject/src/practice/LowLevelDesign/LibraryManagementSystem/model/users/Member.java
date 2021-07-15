package practice.LowLevelDesign.LibraryManagementSystem.model.users;

import practice.LowLevelDesign.LibraryManagementSystem.util.BookIssueService;
import practice.LowLevelDesign.LibraryManagementSystem.util.Search;

public class Member extends SystemUser {

    // Need to maintain this to keep a count on the books issued by a member as there is a limit to the max books that can be issued on one's name
    private int totalBookCheckout;

    private Search search;
    private BookIssueService bookIssueService;

}
