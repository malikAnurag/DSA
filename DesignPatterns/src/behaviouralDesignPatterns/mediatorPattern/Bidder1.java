package behaviouralDesignPatterns.mediatorPattern;

public class Bidder1 {

    String name;
    int bid;

    public Bidder1(String name) {
        this.name = name;
    }

    // Direct communication with all other bidders (messy!)
    public void placeBid(int amount, Bidder1[] bidders) {
        this.bid = amount;
        System.out.println(name + " placed a bid: " + amount);

        for (Bidder1 b : bidders) {
            if (b != this) {
                b.receiveBid(this, amount);
            }
        }
    }

    public void receiveBid(Bidder1 bidder, int amount) {
        System.out.println(name + " is notified: " + bidder.name +
                " placed a bid of " + amount);
    }

    public static void main(String[] args) {
        Bidder1 bidder1 = new Bidder1("Alice");
        Bidder1 bidder2 = new Bidder1("Bob");
        Bidder1 bidder3 = new Bidder1("Charlie");
        Bidder1[] bidders = {bidder1, bidder2, bidder3};
        // Each bidder directly communicates with others
        bidder1.placeBid(100, bidders);
        bidder2.placeBid(150, bidders);
        bidder3.placeBid(200, bidders);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }
}
