package io.codeforall.fanstatics;

import java.util.Iterator;

public class Range implements Iterable<Integer>{


    private int firstNumber;
    private int lastNumber;


    public Range(int number1, int number2){
        this.firstNumber = number1;
        this.lastNumber = number2;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyLittleIterator(this.firstNumber, this.lastNumber);
    }
}
