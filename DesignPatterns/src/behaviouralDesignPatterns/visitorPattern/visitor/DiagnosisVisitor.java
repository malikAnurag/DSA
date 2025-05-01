package behaviouralDesignPatterns.visitorPattern.visitor;

import behaviouralDesignPatterns.visitorPattern.patient.AdultPatient;
import behaviouralDesignPatterns.visitorPattern.patient.ChildPatient;
import behaviouralDesignPatterns.visitorPattern.patient.SeniorPatient;

public class DiagnosisVisitor implements Visitor {

    @Override
    public void visit(ChildPatient childPatient) {
        System.out.println(
                "Diagnosing a child patient: Check-up and pediatric care.");
    }

    @Override
    public void visit(AdultPatient adultPatient) {
        System.out.println(
                "Diagnosing an adult patient: Routine exams and lifestyle advice.");
    }

    @Override
    public void visit(SeniorPatient seniorPatient) {
        System.out.println(
                "Diagnosing a senior patient: Comprehensive geriatric evaluation.");
    }
}
