package structural.adapterPattern.adapter;

import structural.adapterPattern.device.CoffeeMachine;
import structural.adapterPattern.device.SmartDevice;

// Adapter for Coffee Machine
public class CoffeeMachineAdapter implements SmartDevice {

    private final CoffeeMachine coffeeMachine;

    public CoffeeMachineAdapter(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void turnOn() {
        coffeeMachine.initializeZigbeeConnection();
        coffeeMachine.startBrewing();
    }

    @Override
    public void turnOff() {
        coffeeMachine.stopBrewing();
        coffeeMachine.terminateZigbeeConnection();
    }
}
