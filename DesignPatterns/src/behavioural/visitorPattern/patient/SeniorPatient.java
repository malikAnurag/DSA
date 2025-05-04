package behavioural.visitorPattern.patient;

import behavioural.visitorPattern.visitor.Visitor;

public class SeniorPatient implements Patient{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}