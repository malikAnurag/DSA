package behaviouralDesignPatterns.mediatorPattern.mediator;

import behaviouralDesignPatterns.mediatorPattern.Bidder;

import java.util.ArrayList;
import java.util.List;


// The AuctionHouse keeps a list of all registered bidders.
// When a bid is placed, it notifies all other bidders via the mediator.
public class AuctionHouse implements AuctionMediator {

    private final List<Bidder> bidders = new ArrayList<>();

    @Override
    public void registerBidder(Bidder bidder) {
        bidders.add(bidder);
    }

    @Override
    public void placeBid(Bidder bidder, int amount) {

        System.out.println(bidder.getName() + " placed a bid of " + amount);

        for (Bidder b : bidders) {
            if (b != bidder) {
                b.receiveBid(bidder, amount);
            }
        }
    }
}
