package behaviouralDesignPatterns.strategyPattern.processor;

import behaviouralDesignPatterns.strategyPattern.paymentMethods.PaymentStrategy;

/*
* Solves scalability issues if a new strategy/payment method gets added
* Violates open/closed principle
*
* Very easy to extend without changing any piece of code
* Separation of concerns
* Can add any new behaviour without modifying existing code
*
* */
public class PaymentProcessor {

    private PaymentStrategy paymentStrategy;

    // can dynamically pass any payment strategy here
    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment() {
        paymentStrategy.processPayment();
    }

    // Dynamically change payment strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

}
