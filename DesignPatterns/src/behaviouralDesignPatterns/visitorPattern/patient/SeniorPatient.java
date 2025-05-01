package behaviouralDesignPatterns.visitorPattern.patient;

import behaviouralDesignPatterns.visitorPattern.visitor.Visitor;

public class SeniorPatient implements Patient{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}