package behaviouralDesignPatterns.mediatorPattern.mediator;

import behaviouralDesignPatterns.mediatorPattern.Bidder;

public interface AuctionMediator {

    void registerBidder(Bidder bidder);

    void placeBid(Bidder bidder, int amount);
}
