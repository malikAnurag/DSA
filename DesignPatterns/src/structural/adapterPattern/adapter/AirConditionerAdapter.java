package structural.adapterPattern.adapter;

import structural.adapterPattern.device.AirConditioner;
import structural.adapterPattern.device.SmartDevice;

public class AirConditionerAdapter implements SmartDevice {

    private final AirConditioner airConditioner;
    // Constructor
    public AirConditionerAdapter(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void turnOn() {
        airConditioner.connectViaBluetooth();
        airConditioner.startCooling();
    }

    @Override
    public void turnOff() {
        airConditioner.stopCooling();
        airConditioner.disconnectBluetooth();
    }
}
