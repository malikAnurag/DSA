package structural.proxyPattern.main;

import structural.proxyPattern.proxy.ProxyVideoService;
import structural.proxyPattern.subject.RealVideoService;

// The Proxy Design Pattern is a powerful tool for controlling access to objects while adding additional
// functionality like caching and request limiting.

// In our video streaming application example, the proxy acts as a gatekeeper, ensuring secure, efficient,
// and scalable access to video content.

// By decoupling access control from the core service logic, the Proxy Pattern simplifies maintenance,
// enhances security, and improves performance.
// Whether you’re building a video streaming service, a security system, or a caching mechanism,
// the Proxy Pattern is an essential design pattern for clean and robust architecture.

public class Main {

    public static void main(String[] args) {

        RealVideoService realService = new RealVideoService();
        ProxyVideoService proxyService = new ProxyVideoService(realService);

        // Free user trying to watch a video
        proxyService.playVideo("free", "Free Video 1");

        // Premium user trying to watch a video
        proxyService.playVideo("premium", "Premium Video 1");

        // Unauthorized user
        proxyService.playVideo("guest", "Video 1");

        // Too many requests
        for (int i = 0; i < 6; i++) {
            proxyService.playVideo("free", "Free Video 2");
        }
    }
}
