package behavioural.templatePattern.drink;

public class CoffeeBeverage extends Beverage {

    @Override
    void brew() {
        System.out.println("Brewing coffee...");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding sugar and milk...");
    }

    // Suppose this customer doesn't want condiments
    @Override
    boolean customerWantsCondiments() {
        return false;
    }
}
