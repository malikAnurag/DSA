package behaviouralDesignPatterns.strategyPattern.main;

import behaviouralDesignPatterns.strategyPattern.paymentMethods.ApplePay;
import behaviouralDesignPatterns.strategyPattern.paymentMethods.CreditCard;
import behaviouralDesignPatterns.strategyPattern.paymentMethods.PaymentStrategy;
import behaviouralDesignPatterns.strategyPattern.processor.PaymentProcessor;

public class StrategyMainClass {

    public static void main(String[] args) {

        PaymentStrategy creditCardStrategy = new CreditCard();
        PaymentProcessor cardPaymentProcessor = new PaymentProcessor(creditCardStrategy);

        cardPaymentProcessor.processPayment();

        PaymentStrategy applePayStrategy = new ApplePay();
        PaymentProcessor applePayPaymentProcessor = new PaymentProcessor(applePayStrategy);

        applePayPaymentProcessor.processPayment();
    }
}
