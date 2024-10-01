package io.codeforall.fanSTATICS;

public class Sandbox {

    public static void main(String[] args) {

        Hotel hotel1 = new Hotel(3);

        Person person1 = new Person("Mário");
        Person person2 = new Person ("Ricardo");
        Person person3 = new Person ("Ricardo");
        Person person4 = new Person ("Ricardo");
        Person person5 = new Person ("Ricardo");


        person1.needRoom(hotel1);
        person2.needRoom(hotel1);
        person3.needRoom(hotel1);
        person4.needRoom(hotel1);
        person5.needRoom(hotel1);
        person1.checkOut(hotel1);




    }
}
