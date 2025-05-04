package behavioural.mediatorPattern;

import behavioural.mediatorPattern.mediator.AuctionMediator;

// Each bidder holds a reference to the mediator instead of knowing about other bidders
// This makes the code much cleaner and decoupled.
public class Bidder {

    private final String name;
    private final AuctionMediator mediator;

    public Bidder(String name, AuctionMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void placeBid(int amount) {
        mediator.placeBid(this, amount);
    }

    public void receiveBid(Bidder bidder, int amount) {
        System.out.println(name + " is notified: " + bidder.getName() +
                " placed a bid of " + amount);
    }
}
