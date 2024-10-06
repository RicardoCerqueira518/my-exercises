package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.field.Position;

abstract  public class Car {

    Position position = new Position();
    private boolean crashed = false;


    /** The position of the car on the grid */
    public Position getPos() {
        return position; }

    public boolean isCrashed() {
        return crashed;
    }

    public void setCrashed(boolean crashed){
        this.crashed = crashed;
    }

    public  abstract int getSpeed();

    public void move() {
        if (!crashed){
            position.moveRandomly(getSpeed());
        }
    }

}
