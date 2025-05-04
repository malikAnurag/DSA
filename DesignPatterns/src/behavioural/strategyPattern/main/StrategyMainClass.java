package behavioural.strategyPattern.main;

import behavioural.strategyPattern.paymentMethods.ApplePay;
import behavioural.strategyPattern.paymentMethods.CreditCard;
import behavioural.strategyPattern.paymentMethods.PaymentStrategy;
import behavioural.strategyPattern.processor.PaymentProcessor;

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
