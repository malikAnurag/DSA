package behavioural.commandPattern.object;

public class RemoteControl_withoutCommandPattern {

    public Tv tv;

    public RemoteControl_withoutCommandPattern(Tv tv) {
        this.tv = tv;
    }

    public void pressOnButton() {
        tv.turnOn();
    }

    public void pressOffButton() {
        tv.turnOff();
    }

    public void pressChannelButton(int channel) {
        tv.changeChannel(channel);
    }

    public void pressVolumeButton(int volume) {
        tv.adjustVolume(volume);
    }

    public void pressOnChangeVolumeAndChannelButton(int volume, int channel) {
        tv.turnOn();
        tv.changeChannel(channel);
        tv.adjustVolume(volume);
    }
}
