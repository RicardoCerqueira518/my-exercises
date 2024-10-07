package io.codeforall.bootcamp.gameobject.barrel;

import io.codeforall.bootcamp.gameobject.Destroyable;
import io.codeforall.bootcamp.gameobject.GameObject;

public class Barrel extends GameObject implements Destroyable {
    public BarrelType barrelType;
    public int currentDamage;
    public boolean destroyed;

    @Override
    public void hit(int damage) {
        currentDamage++;

    }

    @Override
    public boolean isDestroyed(){
        //FALTA COLOCAR O TIPO DE BARREL PARA EXPLODIR

        return currentDamage>= //TIPO DE BARREL
    }

    @Override
    public String getMessage() {
        return "Barrel target! Explode it!";
    }


}
