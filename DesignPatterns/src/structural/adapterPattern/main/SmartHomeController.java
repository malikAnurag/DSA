package structural.adapterPattern.main;

import structural.adapterPattern.adapter.AirConditionerAdapter;
import structural.adapterPattern.adapter.CoffeeMachineAdapter;
import structural.adapterPattern.adapter.SmartLightAdapter;
import structural.adapterPattern.device.AirConditioner;
import structural.adapterPattern.device.CoffeeMachine;
import structural.adapterPattern.device.SmartDevice;
import structural.adapterPattern.device.SmartLight;


// Centralized app that controls various devices
// Each device comes from different manufacturers and they all communicate differently

// Used AFTER an interface is already created
// Acts as a bridge b/w two incompatible interfaces

// Consider using an hdmi to mini-hdmi adapter

// The Adapter Pattern achieves this by introducing a new class (the Adapter) that implements the interface expected by the client (e.g., the SmartHomeController)
// and translates its requests into commands that the incompatible class (the device) understands.

// Real life examples : Smart home systems, Media players, database drivers

public class SmartHomeController {

    public static void main(String[] args) {

        // Create adapters for each device
        SmartDevice airConditioner = new AirConditionerAdapter(new AirConditioner());
        SmartDevice smartLight = new SmartLightAdapter(new SmartLight());
        SmartDevice coffeeMachine = new CoffeeMachineAdapter(new CoffeeMachine());

        // Control devices through the unified interface
        airConditioner.turnOn();
        smartLight.turnOn();
        coffeeMachine.turnOn();
        airConditioner.turnOff();
        smartLight.turnOff();
        coffeeMachine.turnOff();
    }
}
