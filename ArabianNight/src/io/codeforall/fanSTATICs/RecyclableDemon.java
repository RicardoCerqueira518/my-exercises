package io.codeforall.fanSTATICs;

public class RecyclableDemon extends Genie{

    private boolean hasBeenRecycled;

    public RecyclableDemon() {
        this.hasBeenRecycled = false;

    }
    @Override
    public void wish() {

        System.out.println("Wish granted!");
    }


    @Override
    public boolean isDemon() {
        return demon = false;
    }

    public boolean isHasBeenRecycled() {
        return hasBeenRecycled = true;
    }
}
