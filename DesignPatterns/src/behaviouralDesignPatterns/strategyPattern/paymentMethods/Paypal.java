package behaviouralDesignPatterns.strategyPattern.paymentMethods;

public class Paypal implements PaymentStrategy{

    @Override
    public void processPayment() {
        System.out.println("PayPal payment");
    }
}
