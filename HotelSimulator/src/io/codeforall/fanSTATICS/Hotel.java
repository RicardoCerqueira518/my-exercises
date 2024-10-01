package io.codeforall.fanSTATICS;

public class Hotel {


    int maxRooms;
    private Room[] rooms;
    public int key;


    public Hotel(int maxRooms) {
        this.maxRooms = maxRooms;
        rooms = new Room[this.maxRooms];
        for (int i = 0; i < maxRooms; i++) {
             rooms[i] = new Room();
        }
    }

    public int checkIn(){
        for (int i = 0; i < rooms.length; i++) {
            if (!rooms[i].isAvailable()) {
                rooms[i].changeState();
                key = i;
                System.out.println("Your room number is: " + (i + 1) + ", here's your key.");
                return key;
            }
        }
        System.out.println("Sorry, we don't have any rooms available.");
        return 0;
    }
    public void checkOut(int key) {
        if (key < 0) {
            System.out.println("Are you sure the key belongs to this hotel?");
            return;
        }

        rooms[key].changeState();
        System.out.println("Thank you for your stay, see you soon");
    }
}
