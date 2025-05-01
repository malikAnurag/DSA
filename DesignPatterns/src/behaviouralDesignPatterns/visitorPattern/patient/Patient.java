package behaviouralDesignPatterns.visitorPattern.patient;

import behaviouralDesignPatterns.visitorPattern.visitor.Visitor;

public interface Patient {

    void accept(Visitor visitor);
}
