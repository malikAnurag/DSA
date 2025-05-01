package behaviouralDesignPatterns.chainOfResponsibility.handlers;

public class Director extends Approver {

    @Override
    public void processLeaveRequest(int leaveDays) {
        if (leaveDays <= 14) {
            System.out.println("Director approved the leave.");
        } else if (nextApprover != null) { // Pass on if not handled
            nextApprover.processLeaveRequest(leaveDays);
        } else {
            System.out.println("Leave request denied. Too many days!");
        }
    }
}
