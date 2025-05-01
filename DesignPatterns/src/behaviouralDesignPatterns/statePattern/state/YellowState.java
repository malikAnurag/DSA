package behaviouralDesignPatterns.statePattern.state;

import behaviouralDesignPatterns.statePattern.context.TrafficLightContext;

public class YellowState implements TrafficLightState {

    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Switching from YELLOW to RED. Stop!");
        context.setState(new RedState());
    }

    @Override
    public String getColor() {
        return "YELLOW";
    }
}
