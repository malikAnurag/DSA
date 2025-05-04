package behavioural.visitorPattern.patient;

import behavioural.visitorPattern.visitor.Visitor;

public class ChildPatient implements Patient{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}