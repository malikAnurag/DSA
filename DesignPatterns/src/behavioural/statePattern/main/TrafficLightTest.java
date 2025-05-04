package behavioural.statePattern.main;

import behavioural.statePattern.context.TrafficLightContext;

// This pattern allows an object to alter its behavior when its internal state changes by delegating state-specific behaviors to separate classes.
// It promotes cleaner code, easier maintenance, and better scalability.
public class TrafficLightTest {

    public static void main(String[] args) {

        TrafficLightContext trafficLight = new TrafficLightContext();
        trafficLight.next(); // RED -> GREEN
        trafficLight.next(); // GREEN -> YELLOW
        trafficLight.next(); // YELLOW -> RED
        trafficLight.next(); // RED -> GREEN
        // Adding new states like BLINKING or MAINTENANCE is easy now
    }
}
