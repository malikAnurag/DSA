package behavioural.templatePattern.drink;

// Our abstract template that defines the skeleton of beverage preparation
public abstract class Beverage {

    // The template method with a hook
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        // Only add condiments if the customer wants them
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    void boilWater() {
        System.out.println("Boiling water...");
    }

    void pourInCup() {
        System.out.println("Pouring into cup...");
    }

    abstract void brew();

    abstract void addCondiments();

    // Hook method with default behavior
    boolean customerWantsCondiments() {
        return true;
    }
}
