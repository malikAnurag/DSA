package behavioural.commandPattern.command;

import behavioural.commandPattern.object.Tv;

public class AdjustVolumeCommand implements Command {

    private final Tv tv;
    private final int volume;

    public AdjustVolumeCommand(Tv tv, int volume) {
        this.tv = tv;
        this.volume = volume;
    }

    @Override
    public void execute() {
        tv.adjustVolume(volume);
    }
}
