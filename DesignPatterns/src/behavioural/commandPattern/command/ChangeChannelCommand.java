package behavioural.commandPattern.command;

import behavioural.commandPattern.object.Tv;

public class ChangeChannelCommand implements Command {

    private final Tv tv;
    private final int channel;

    public ChangeChannelCommand(Tv tv, int channel) {
        this.tv = tv;
        this.channel = channel;
    }

    @Override
    public void execute() {
        tv.changeChannel(channel);
    }
}
