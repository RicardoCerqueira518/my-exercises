package io.codeforall.fanSTATICs;

public class Genie {

    private int maxWishes;
    private int wishCounter = 0;

    public Genie(){
        this.maxWishes = 3;
    }

    public int getWishCounter() {
        return wishCounter;
    }

    public void wish() {
        wishCounter++;
        if (wishCounter <= maxWishes) {
            System.out.println("Wish granted!. You have used " + wishCounter + " wish, of " + maxWishes + ".");
            return;
        }
        System.out.println("No more wishes bitch!");
    }

    public void incWishCounter() {
        this.wishCounter++;
    }
}
