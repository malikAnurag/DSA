package behaviouralDesignPatterns.visitorPattern.main;

import behaviouralDesignPatterns.visitorPattern.patient.AdultPatient;
import behaviouralDesignPatterns.visitorPattern.patient.ChildPatient;
import behaviouralDesignPatterns.visitorPattern.patient.Patient;
import behaviouralDesignPatterns.visitorPattern.patient.SeniorPatient;
import behaviouralDesignPatterns.visitorPattern.visitor.BillingVisitor;
import behaviouralDesignPatterns.visitorPattern.visitor.DiagnosisVisitor;
import behaviouralDesignPatterns.visitorPattern.visitor.Visitor;

public class HospitalVisitDemo {

    public static void main(String[] args) {
        // Create an array of patients
        Patient[] patients = {new ChildPatient(), new AdultPatient(), new SeniorPatient()};

        // Create visitors for different operations
        Visitor diagnosisVisitor = new DiagnosisVisitor();
        Visitor billingVisitor = new BillingVisitor();

        // Each patient accepts the visitors to perform the operations
        for (Patient patient : patients) {
            patient.accept(diagnosisVisitor);
            patient.accept(billingVisitor);
        }
    }
}
