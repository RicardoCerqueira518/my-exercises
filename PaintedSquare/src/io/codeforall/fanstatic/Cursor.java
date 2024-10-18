package io.codeforall.fanstatic;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Cursor implements KeyboardHandler {

    private Rectangle cursor;
    private int x=0;
    private int y=0;
    private boolean space;
    private org.academiadecodigo.simplegraphics.keyboard.Keyboard keyboard;

    Grid grid = new Grid();


    public Cursor(int x, int y, int width, int height){
        cursor = new Rectangle(x,y,width,height);
        cursor.setColor(Color.BLACK);
        cursor.fill();
    }

    public Cursor(){

    }

    public Rectangle getCursor(){
        return cursor;
    }

    public void translateSquare(int x, int y){
        cursor.translate(x,y);
    }


    public void init() {
        this.keyboard = new org.academiadecodigo.simplegraphics.keyboard.Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);

        KeyboardEvent paint = new KeyboardEvent();
        paint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        paint.setKey(KeyboardEvent.KEY_SPACE);

        KeyboardEvent clear = new KeyboardEvent();
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        clear.setKey(KeyboardEvent.KEY_C);

        KeyboardEvent save = new KeyboardEvent();
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        save.setKey(KeyboardEvent.KEY_S);

        KeyboardEvent notPaint = new KeyboardEvent();
        notPaint.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        notPaint.setKey(KeyboardEvent.KEY_SPACE);

        KeyboardEvent load = new KeyboardEvent();
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        load.setKey(KeyboardEvent.KEY_L);

        keyboard.addEventListener(right);
        keyboard.addEventListener(left);
        keyboard.addEventListener(down);
        keyboard.addEventListener(up);
        keyboard.addEventListener(paint);
        keyboard.addEventListener(clear);
        keyboard.addEventListener(save);
        keyboard.addEventListener(notPaint);
        keyboard.addEventListener(load);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                space = false;
                break;
            case KeyboardEvent.KEY_UP:
                if(cursor.getY()>0){
                    translateSquare(0,-grid.CELL_SIZE);
                    y--;
                    System.out.println("move up");
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                if(cursor.getY()<(grid.getRows()-1)){
                    translateSquare(0, grid.getRows());
                    x++;
                    System.out.println("move down");
                }
                break;


        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


    private void checkSpace() {
        if (space) {
            checkColor();
        }
    }

    private void checkColor() {
    }
}


