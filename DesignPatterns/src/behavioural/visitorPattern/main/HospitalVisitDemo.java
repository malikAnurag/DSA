package behavioural.visitorPattern.main;

import behavioural.visitorPattern.patient.AdultPatient;
import behavioural.visitorPattern.patient.ChildPatient;
import behavioural.visitorPattern.patient.Patient;
import behavioural.visitorPattern.patient.SeniorPatient;
import behavioural.visitorPattern.visitor.BillingVisitor;
import behavioural.visitorPattern.visitor.DiagnosisVisitor;
import behavioural.visitorPattern.visitor.Visitor;

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
