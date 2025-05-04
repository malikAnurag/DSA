package structural.adapterPattern.adapter;

import structural.adapterPattern.device.SmartDevice;
import structural.adapterPattern.device.SmartLight;

// Adapter for Smart Light
public class SmartLightAdapter implements SmartDevice {

    private final SmartLight smartLight;

    public SmartLightAdapter(SmartLight smartLight) {
        this.smartLight = smartLight;
    }

    @Override
    public void turnOn() {
        smartLight.connectToWiFi();
        smartLight.switchOn();
    }

    @Override
    public void turnOff() {
        smartLight.switchOff();
        smartLight.disconnectWiFi();
    }
}
