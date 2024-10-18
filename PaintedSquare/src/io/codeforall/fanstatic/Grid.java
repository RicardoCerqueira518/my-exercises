package io.codeforall.fanstatic;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    public static final int PADDING = 10;
    public static final int CELL_SIZE = 30;

    private int cols;
    private int rows;
    private Rectangle rectangle;
    private Rectangle[][] cell;
    private Rectangle cursor;
    private Rectangle field;

    /**
     * Simple graphics grid constructor with a certain number of rows and columns
     *
     * @param cols number of the columns
     * @param rows number of rows
     */
    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;

    }

    public Grid(){

    }

    /**
     * Initializes the field simple graphics rectangle and draws it
     */
    public void init() {
        drawGrid();
        Cursor cursor = new Cursor(PADDING, PADDING,CELL_SIZE, CELL_SIZE);
        cursor.init();
    }


    public void drawGrid() {
        cell= new Rectangle[this.cols][this.rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                Rectangle rectangle = new Rectangle(PADDING+ CELL_SIZE *i, PADDING+ CELL_SIZE *j, CELL_SIZE, CELL_SIZE);
                rectangle.draw();
            }
        }
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }



}
