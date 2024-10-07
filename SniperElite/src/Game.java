public class Game {


    SniperRifle sniperRifle = new SniperRifle();
    public int shotsFired;

    GameObject[] gameObject = new GameObject[30];
    GameObject armouredEnemy = new ArmouredEnemy();
    GameObject tree = new Tree();
    GameObject soldierEnemy = new SoldierEnemy();


    public void Start() {

    }

    public GameObject[] createObject(int numberObject) {
        GameObject gameObjects = new GameObject[numberObject];

        numberObject = (int) Math.random();
        for (int i = 0; i < numberObject; i++) {
            gameObjects[i] = gameObjects;
            if (numberObject < 0.33) {
                System.out.println("I'm a armoured Enemy");
                return armouredEnemy;
            } if (numberObject < 0.66)
                System.out.println("I'm a soldier Enemy");
                return soldierEnemy;

        }
        return tree;
    }
}
