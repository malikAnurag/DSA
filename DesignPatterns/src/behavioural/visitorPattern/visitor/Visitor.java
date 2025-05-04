package behavioural.visitorPattern.visitor;

import behavioural.visitorPattern.patient.AdultPatient;
import behavioural.visitorPattern.patient.ChildPatient;
import behavioural.visitorPattern.patient.SeniorPatient;

public interface Visitor {

    void visit(ChildPatient childPatient);
    void visit(AdultPatient adultPatient);
    void visit(SeniorPatient seniorPatient);
}
