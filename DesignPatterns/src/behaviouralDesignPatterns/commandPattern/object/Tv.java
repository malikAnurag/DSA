package behaviouralDesignPatterns.commandPattern.object;

public class Tv {

    public void turnOn() {
        System.out.println("Tv is on");
    }

    public void turnOff(){
        System.out.println("Tv is off");
    }

    public void changeChannel(int channel) {
        System.out.println("Channel changed to : " + channel);
    }

    public void adjustVolume(int volume) {
        System.out.println("Volume changed to : " + volume);
    }
}
