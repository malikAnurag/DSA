package behavioural.mediatorPattern.mediator;

import behavioural.mediatorPattern.Bidder;

public interface AuctionMediator {

    void registerBidder(Bidder bidder);

    void placeBid(Bidder bidder, int amount);
}
