package io.codeforall.bootcamp.cars;

public class Mustang extends Car{

    public Mustang() {

        position.initialPos();
    }

    @Override
    public int getSpeed(){
        return 2; //Fiat tem 1, Mustang tem 2;
    }

    @Override
    public String toString() {
        return "M";
    }

}
