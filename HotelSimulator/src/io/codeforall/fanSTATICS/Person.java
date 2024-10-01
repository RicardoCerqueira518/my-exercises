package io.codeforall.fanSTATICS;

public class Person {

    private String name;
    public int key;

    public Person(String name){
        this.name = name;
        this.key = 9999;
    }

    public void needRoom (Hotel hotel) {
       key = hotel.checkIn();

    }

    public void checkOut (Hotel hotel) {
        hotel.checkOut(key);
    }

    public int getKey() {
        return key;
    }
}
