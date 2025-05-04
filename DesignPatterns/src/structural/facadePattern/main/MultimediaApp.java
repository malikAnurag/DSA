package structural.facadePattern.main;

import structural.facadePattern.facade.MediaFacade;
import java.util.Scanner;


// The Facade Design Pattern simplifies complex systems by providing a unified interface that hides the intricacies of subsystems.
// In our multimedia application example, the facade enables users to play music, videos, and images seamlessly without worrying about the underlying details.
// By centralizing interaction logic, the facade pattern improves maintainability, scalability, and flexibility, making it an essential tool for designing clean, user-friendly systems.

public class MultimediaApp {

    public static void main(String[] args) {

        MediaFacade mediaFacade = new MediaFacade();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Multimedia App!");
        System.out.println("Choose an action: playMusic, playVideo, viewImage");
        String action = scanner.nextLine();
        mediaFacade.performAction(action);
        scanner.close();
    }
}
