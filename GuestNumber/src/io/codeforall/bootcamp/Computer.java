package io.codeforall.bootcamp;

public class Computer {
    public int playerNumber;
    public int computerNumber;


    public Computer(int computerNumber) {
        this.computerNumber = computerNumber;
    }

    public void compare(int playerNumber, int computerNumber) {
        this.computerNumber = computerNumber;
        this.playerNumber = playerNumber;
        while (playerNumber != computerNumber) {
            System.out.println("No match!");
            System.out.println(computerNumber);
            System.out.println(playerNumber);
            playerNumber = NumberGenerator.randomNumber();
        }
        if (playerNumber == computerNumber) {
            System.out.println("Correct you guessed it!");
            System.out.println(computerNumber);
            System.out.println(playerNumber);
        }
    }
}


