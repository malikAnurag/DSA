package behaviouralDesignPatterns.visitorPattern.visitor;

import behaviouralDesignPatterns.visitorPattern.patient.AdultPatient;
import behaviouralDesignPatterns.visitorPattern.patient.ChildPatient;
import behaviouralDesignPatterns.visitorPattern.patient.SeniorPatient;

public interface Visitor {

    void visit(ChildPatient childPatient);
    void visit(AdultPatient adultPatient);
    void visit(SeniorPatient seniorPatient);
}
