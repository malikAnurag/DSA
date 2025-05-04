package behavioural.visitorPattern.patient;

import behavioural.visitorPattern.visitor.Visitor;

public interface Patient {

    void accept(Visitor visitor);
}
