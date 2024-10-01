package io.codeforall.fanSTATICS;

public class Room {

    private boolean isAvailable;


    public Room() {
        this.isAvailable = false;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void changeState() {
        isAvailable = !isAvailable;
    }
}
