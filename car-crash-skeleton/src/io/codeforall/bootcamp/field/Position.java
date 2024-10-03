package io.codeforall.bootcamp.field;

import io.codeforall.bootcamp.Game;

public class Position {


    private int col;
    private int row;

    public int getCol() {
        return this.col = (int) Math.random()*Field.getWidth();
    }

    public int getRow() {
        return this.row = (int) Math.random()*Field.getHeight();
    }

    public void initialPos (){
        getRow();
        getCol();
    }


}
