package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.field.Position;

public class Fiat extends Car{

    public Fiat() {
        position.initialPos();
    }

    @Override
    public int getSpeed(){
        return 1; //Fiat tem 1 e Mustang tem 2;
    }

    @Override
    public String toString() {
        return this.isCrashed() ? "C" : "F";
    }

}
