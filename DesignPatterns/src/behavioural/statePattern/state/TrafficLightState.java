package behavioural.statePattern.state;

import behavioural.statePattern.context.TrafficLightContext;

public interface TrafficLightState {

    void next(TrafficLightContext context);
    String getColor();
}
