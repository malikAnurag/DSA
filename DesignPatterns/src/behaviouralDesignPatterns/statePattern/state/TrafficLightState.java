package behaviouralDesignPatterns.statePattern.state;

import behaviouralDesignPatterns.statePattern.context.TrafficLightContext;

public interface TrafficLightState {

    void next(TrafficLightContext context);
    String getColor();
}
