package structural.compositePattern.main;

import structural.compositePattern.component.AirConditioner;
import structural.compositePattern.component.CompositeSmartComponent;
import structural.compositePattern.component.SmartComponent;
import structural.compositePattern.component.SmartLight;


// Problem : Managing hierarchical structures
// House contains multiple floors -> Floor contains multiple rooms -> Room contains multiple devices

// The Composite Design Pattern is specifically designed to handle hierarchies.
// It allows you to treat individual objects and groups of objects (composites) uniformly.
// In our smart home system, the pattern enables you to control individual devices, rooms, floors, and even the entire house seamlessly through a single interface.
public class SmartHomeController {

    public static void main(String[] args) {

        // Create individual devices
        SmartComponent airConditioner = new AirConditioner();
        SmartComponent smartLight = new SmartLight();

        // Create a room and add devices
        CompositeSmartComponent room1 = new CompositeSmartComponent();
        room1.addComponent(airConditioner);
        room1.addComponent(smartLight);

        // Add more rooms for demonstration
        CompositeSmartComponent room2 = new CompositeSmartComponent();
        room2.addComponent(new AirConditioner());
        room2.addComponent(new SmartLight());

        // Create a floor and add rooms
        CompositeSmartComponent floor = new CompositeSmartComponent();
        floor.addComponent(room1);
        floor.addComponent(room2);

        // Create the house and add floors
        CompositeSmartComponent house = new CompositeSmartComponent();
        house.addComponent(floor);

        // Control the entire house
        System.out.println("Turning ON all devices in the house:");
        house.turnOn();
        System.out.println("\nTurning OFF all devices in the house:");
        house.turnOff();

        // Control a single floor
        System.out.println("\nTurning ON all devices on the first floor:");
        floor.turnOn();
        System.out.println("\nTurning OFF all devices on the first floor:");
        floor.turnOff();

        // Control a single room
        System.out.println("\nTurning ON all devices in Room 1:");
        room1.turnOn();
        System.out.println("\nTurning OFF all devices in Room 1:");
        room1.turnOff();
    }
}
