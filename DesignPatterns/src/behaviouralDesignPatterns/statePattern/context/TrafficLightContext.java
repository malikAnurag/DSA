package behaviouralDesignPatterns.statePattern.context;

import behaviouralDesignPatterns.statePattern.state.RedState;
import behaviouralDesignPatterns.statePattern.state.TrafficLightState;

// Context class that maintains a reference to the current state and delegates state-specific behavior to the current state.
public class TrafficLightContext {

    private TrafficLightState currentState;

    public TrafficLightContext() {
        currentState = new RedState(); // Start with RED
    }

    public void setState(TrafficLightState state) {
        this.currentState = state;
    }

    public void next() {
        currentState.next(this);
    }

    public String getColor() {
        return currentState.getColor();
    }
}
