package behavioural.mediatorPattern.mediator;

import behavioural.mediatorPattern.Bidder;

// What if you want to add a new feature like logging each bid or integrating a bidding timer?”
// With our mediator pattern, you can simply extend the mediator without touching the bidder classes.
// We'll extend our existing AuctionHouse to create an ExtendedAuctionHouse that logs every bid and enforces a bidding timer.
// Bids submitted after the bidding period will be rejected.
public class ExtendedAuctionHouse extends AuctionHouse {

    private final long biddingEndTime;  // Timestamp when bidding ends

    public ExtendedAuctionHouse(long biddingEndTime) {
        this.biddingEndTime = biddingEndTime;
    }

    @Override
    public void placeBid(Bidder bidder, int amount) {
        // Check if bidding time is still open
        if (System.currentTimeMillis() > biddingEndTime) {
            System.out.println("Bidding time is over. No more bids accepted.");
            return;
        }
        // Log the bid
        System.out.println("LOG: " + bidder.getName() + " is bidding " + amount);
        // Delegate to the original mediator logic to notify other bidders
        super.placeBid(bidder, amount);
    }
}