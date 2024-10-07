abstract class Enemy extends GameObject {

    int health;
    boolean isDead = false;
    private String message = "Enemy";


    public boolean isDead(){
        return this.isDead;
    }


    public void hit (int hit){

    }

    @Override
    public String getMessage (){
        return this.message;
    }

}
