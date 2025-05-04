package behavioural.commandPattern.object;

import behavioural.commandPattern.command.Command;

public class RemoteControl {

    private Command onCommand;
    private Command offCommand;

    public void setOffCommand(Command offCommand) {
        this.offCommand = offCommand;
    }

    public void setOnCommand(Command onCommand) {
        this.onCommand = onCommand;
    }

    public void pressOnButton() {
        onCommand.execute();
    }

    public void pressOffButton() {
        offCommand.execute();
    }
}
