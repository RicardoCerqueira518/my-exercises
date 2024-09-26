package io.codeforall.bootcamp;

public class Sandbox {

    public static void main(String[] args) {
        Computer computer1 = new Computer(NumberGenerator.randomNumber());
        Player player1 = new Player(NumberGenerator.randomNumber());

        computer1.compare(player1.playerNumber, computer1.computerNumber);


    }

}
