package behaviouralDesignPatterns.strategyPattern.paymentMethods;

public class ApplePay implements PaymentStrategy{

    @Override
    public void processPayment() {
        System.out.println("Apple Pay payment");
    }
}
