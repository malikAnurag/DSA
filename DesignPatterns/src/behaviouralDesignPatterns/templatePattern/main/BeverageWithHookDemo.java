package behaviouralDesignPatterns.templatePattern.main;

import behaviouralDesignPatterns.templatePattern.drink.Beverage;
import behaviouralDesignPatterns.templatePattern.drink.CoffeeBeverage;

// It’s called the Template Design Pattern because it provides a fixed “template” for an algorithm
// The steps are defined in a base class, but the details (like brewing coffee vs. steeping tea) are left for the subclasses
// This ensures that the overall process remains consistent while allowing flexibility for variations—just like following a cookie recipe and swapping out ingredients!

// Real life examples : Cooking recipes, game development, document processing
public class BeverageWithHookDemo {

    public static void main(String[] args) {
        Beverage coffee = new CoffeeBeverage();
        System.out.println("Making custom coffee...");
        coffee.prepareRecipe();
    }
}
