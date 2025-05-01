package behaviouralDesignPatterns.visitorPattern.visitor;

import behaviouralDesignPatterns.visitorPattern.patient.AdultPatient;
import behaviouralDesignPatterns.visitorPattern.patient.ChildPatient;
import behaviouralDesignPatterns.visitorPattern.patient.SeniorPatient;

public class BillingVisitor implements Visitor {

    @Override
    public void visit(ChildPatient childPatient) {
        System.out.println("Calculating billing for a child patient.");
    }

    @Override
    public void visit(AdultPatient adultPatient) {
        System.out.println("Calculating billing for an adult patient.");
    }

    @Override
    public void visit(SeniorPatient seniorPatient) {
        System.out.println("Calculating billing for a senior patient.");
    }
}
