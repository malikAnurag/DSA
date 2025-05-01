package behaviouralDesignPatterns.commandPattern.command;

import behaviouralDesignPatterns.commandPattern.object.Tv;

public class TurnOffCommand implements Command{

    private final Tv tv;

    public TurnOffCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
    }
}
