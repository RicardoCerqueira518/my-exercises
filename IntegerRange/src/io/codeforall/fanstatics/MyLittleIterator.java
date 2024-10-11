package io.codeforall.fanstatics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLittleIterator implements Iterator<Integer> {


    private int firstNumber;
    private int lastNumber;
    private int counter;


    public MyLittleIterator(int firstNumber, int lastNumber){
        this.firstNumber = firstNumber;
        this.lastNumber = lastNumber;
        this.counter = firstNumber;

    }

    @Override
    public boolean hasNext() {
        return counter < lastNumber;
    }

    @Override
    public Integer next() {

        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return counter++;
    }
}
