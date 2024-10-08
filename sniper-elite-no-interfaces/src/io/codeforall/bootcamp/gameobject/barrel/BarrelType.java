package io.codeforall.bootcamp.gameobject.barrel;

public enum BarrelType {

    PLASTIC(2),
    WOOD(3),
    METAL(4);

    public int maxDamage;

    BarrelType(int maxDamage) {
        this.maxDamage = maxDamage;
    }


    public int getMaxDamage() {
        return maxDamage;
    }


}
