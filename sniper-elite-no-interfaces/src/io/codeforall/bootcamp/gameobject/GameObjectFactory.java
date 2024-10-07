package io.codeforall.bootcamp.gameobject;

import io.codeforall.bootcamp.gameobject.barrel.Barrel;
import io.codeforall.bootcamp.gameobject.barrel.BarrelType;
import io.codeforall.bootcamp.gameobject.enemy.ArmouredEnemy;
import io.codeforall.bootcamp.gameobject.enemy.Enemy;
import io.codeforall.bootcamp.gameobject.enemy.SoldierEnemy;

public class GameObjectFactory {

    public static int ENEMY_HEALTH = 3;
    public static int ARMOUR = 3;

    public static Enemy createEnemy() {

        return Math.random() > 0.5 ? new SoldierEnemy(ENEMY_HEALTH) : new ArmouredEnemy(ENEMY_HEALTH, ARMOUR);

    }

    public static Barrel createBarrel() {

        int random = (int) (Math.random() * BarrelType.values().length);
        BarrelType barrelType = BarrelType.values()[random];

        Barrel barrel;

        switch (barrelType) {
            case PLASTIC, WOOD, METAL:
            default:
                barrel = new Barrel();
        }
        return barrel;
    }
}
