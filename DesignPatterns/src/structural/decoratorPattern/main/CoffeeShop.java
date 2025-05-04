package structural.decoratorPattern.main;

import structural.decoratorPattern.beverage.Cappuccino;
import structural.decoratorPattern.beverage.Coffee;
import structural.decoratorPattern.beverage.Espresso;
import structural.decoratorPattern.decorator.MilkDecorator;
import structural.decoratorPattern.decorator.SugarDecorator;
import structural.decoratorPattern.decorator.VanillaDecorator;

// The Decorator Pattern is designed to dynamically adding new functionalities to objects without modifying their code
// It allows you to wrap objects in layers of functionality, creating flexible and extensible systems
//
// The Decorator Pattern achieves this by:
//  1. Defining a common interface for the base object and its decorators
//  2. Using decorators to wrap base objects, adding new behaviors while preserving the original object’s interface
//  3. Allowing multiple decorators to be stacked dynamically

public class CoffeeShop {

    public static void main(String[] args) {

        Coffee coffee = new Espresso();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        System.out.println("Order: " + coffee.getDescription());
        System.out.println("Total Cost: $" + coffee.getCost());

        Coffee anotherCoffee = new Cappuccino();
        anotherCoffee = new VanillaDecorator(anotherCoffee);
        System.out.println("\nOrder: " + anotherCoffee.getDescription());
        System.out.println("Total Cost: $" + anotherCoffee.getCost());
    }
}
