package io.codeforall.bootcamp.cars;

public class CarFactory {

    private Car newCar;


    public static Car getNewCar() {
        int newCar = (int) Math.floor(Math.random()*2);
        if (newCar == 0) {
            return new Fiat();
        }
        return new Mustang();
    }
}
