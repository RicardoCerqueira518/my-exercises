package io.codeforall.fanSTATICs;

import java.sql.SQLOutput;

public class Lamp {

    private int geniesCounter = 0;
    private int maxGenies;
    private int recyclesNumber = 0;
    private int remainingGenies = maxGenies - geniesCounter;


    public Lamp(int maxGenies){
        this.maxGenies = maxGenies;
    }

    public Genie rub(){
        geniesCounter++;
        if (geniesCounter > maxGenies) {
            System.out.println("Demon: What's your wish?");
            return new RecyclableDemon();
        }
        if (geniesCounter % 2 == 0) {
            System.out.println("Friendly Genie: What's your wish?");
            return new FriendlyGenie();
        }

            System.out.println("Grumpy Genie: What's your wish?");
            return new GrumpyGenie();
    }

    public void recycle(){
        geniesCounter = 0;
        recyclesNumber++;
        System.out.println("Your lamp has been recycled");
    }



   /* public void compare (Lamp lamp){
        if (Lamp == lamp.maxGenies)) {
            System.out.println( "the capacity number is " + maxGenies + " ,the same in both lamps.");
        } else {
            System.out.println("the capacity is not the same in both lamps.");
        }

        if (lamp.equals(lamp.remainingGenies)){
            System.out.println("the remaining genies is: " + remainingGenies + " the same in both lamps.");
        } else {
            System.out.println("the remaining genies is not the same in both lamps.");
        }


        if (lamp.equals(lamp.recyclesNumber)){
            System.out.println("the recycles number is: " + recyclesNumber + " the same in both lamps.");
        } else {
            System.out.println("the recycles number is not the same in both lamps.");
        }

        }

    */



}
