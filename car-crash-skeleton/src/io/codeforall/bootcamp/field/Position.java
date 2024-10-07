package io.codeforall.bootcamp.field;

import io.codeforall.bootcamp.Game;

public class Position {


    private int col;
    private int row;

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void initialPos (){
        this.col = (int) (Math.random()*Field.getWidth());
        this.row = (int) (Math.random()*Field.getHeight());
    }

    public void moveRandomly(int speed){
        int direction = (int) (Math.random()*4);
        int steps = Math.min(speed,2);

        int newCol = col;
        int newRow = row;

        switch (direction){
            case 0: // Up
                newRow = Math.max(0, row - steps);
                break;
            case 1: // Down
                newRow = Math.min(Field.getHeight() - 1, row + steps);
                break;
            case 2: // Left
                newCol = Math.max(0, col - steps);
                break;
            case 3: // Right
                newCol = Math.min(Field.getWidth() - 1, col + steps);
                break;
        }

        col = newCol;
        row = newRow;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if(!(obj instanceof Position)) return false;
        Position other = (Position) obj;
        return this.col == other.col && this.row == other.row;
    }

}
