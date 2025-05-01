package behaviouralDesignPatterns.strategyPattern.paymentMethods;

public class CreditCard implements PaymentStrategy{

    @Override
    public void processPayment() {
        System.out.println("Credit Card payment");
    }
}
