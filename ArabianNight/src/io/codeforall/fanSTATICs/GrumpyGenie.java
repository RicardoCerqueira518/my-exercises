package io.codeforall.fanSTATICs;

public class GrumpyGenie extends Genie {

    public GrumpyGenie() {
    }

    @Override
    public void wish() {
        if(getWishCounter() == 0 ) {
            System.out.println("Wish granted!");
             this.incWishCounter();
             return;
    }   System.out.println("No more wishes bitch!");
    }
}

