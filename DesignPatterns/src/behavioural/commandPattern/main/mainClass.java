package behavioural.commandPattern.main;

/*
*  Wrapping commands (actions you want to perform) as objects which can be : passed, stored, executed when needed
*
* If we want to add new functionality, we'll have to keep modifying the remote control class which leads to
* code duplication and lack of flexibility
*
* All new commands will be made separately
*
* If I want to change my specialized command actions, I can individually only change the specialized command
* the remote control will not change
*
* TV will have it's own actions and will remain as is
*
* */

import behavioural.commandPattern.command.*;
import behavioural.commandPattern.object.RemoteControl;
import behavioural.commandPattern.object.Tv;

public class mainClass {

    public static void main(String[] args) {

        Tv tv = new Tv();

        // create commands
        Command turnOn = new TurnOnCommand(tv);
        Command turnOff = new TurnOffCommand(tv);
        Command changeChannel = new ChangeChannelCommand(tv, 5);
        Command adjustVolume = new AdjustVolumeCommand(tv, 8);

        // create remote control
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setOnCommand(turnOn);
        remoteControl.setOffCommand(turnOff);
        remoteControl.pressOnButton();
        remoteControl.pressOffButton();

        changeChannel.execute();
        adjustVolume.execute();
    }
}
