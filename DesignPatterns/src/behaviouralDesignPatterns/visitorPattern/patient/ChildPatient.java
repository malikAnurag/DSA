package behaviouralDesignPatterns.visitorPattern.patient;

import behaviouralDesignPatterns.visitorPattern.visitor.Visitor;

public class ChildPatient implements Patient{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}