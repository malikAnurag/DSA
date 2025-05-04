package structural.proxyPattern.subject;

public class RealVideoService implements VideoServiceInterface {

    @Override
    public void playVideo(String userType, String videoName) {
        System.out.println("Streaming video: " + videoName);
    }
}