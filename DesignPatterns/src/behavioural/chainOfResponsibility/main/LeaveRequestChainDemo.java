package behavioural.chainOfResponsibility.main;

import behavioural.chainOfResponsibility.handlers.Approver;
import behavioural.chainOfResponsibility.handlers.Director;
import behavioural.chainOfResponsibility.handlers.Manager;
import behavioural.chainOfResponsibility.handlers.Supervisor;

// The pattern allows requests to be passed along the chain dynamically until a suitable handler is found.
// This ensures that each request is handled appropriately, even as the system evolves

// Reusability : Handlers designed for one chain can be reused in other chains or contexts, reducing code duplication and increasing overall reusability.
// Real life examples : Tech support, logging system, GUI event handling
public class LeaveRequestChainDemo {

    public static void main(String[] args) {

        // Create handler instances
        Approver supervisor = new Supervisor();
        Approver manager = new Manager();
        Approver director = new Director();

        // Set up the chain: Supervisor -> Manager -> Director
        supervisor.setNextApprover(manager);
        manager.setNextApprover(director);

        // Process a leave request
        int leaveDays = 10;
        System.out.println("Employee requests " + leaveDays + " days of leave.");
        supervisor.processLeaveRequest(leaveDays);
    }
}
