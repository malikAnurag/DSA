package behavioural.mediatorPattern.main;

import behavioural.mediatorPattern.Bidder;
import behavioural.mediatorPattern.mediator.AuctionHouse;
import behavioural.mediatorPattern.mediator.AuctionMediator;

/*
* Bidders register with the AuctionHouse.
  When a bidder places a bid, the AuctionHouse (mediator) notifies all other bidders.
  The system is now organized, easy to extend, and much cleaner!
* */

public class AuctionMediatorDemo {

    public static void main(String[] args) {

        AuctionMediator auctionHouse = new AuctionHouse();
        Bidder bidder1 = new Bidder("Alice", auctionHouse);
        Bidder bidder2 = new Bidder("Bob", auctionHouse);
        Bidder bidder3 = new Bidder("Charlie", auctionHouse);

        auctionHouse.registerBidder(bidder1);
        auctionHouse.registerBidder(bidder3);
        auctionHouse.registerBidder(bidder2);

        bidder1.placeBid(100);
        bidder2.placeBid(150);
        bidder3.placeBid(200);
    }
}