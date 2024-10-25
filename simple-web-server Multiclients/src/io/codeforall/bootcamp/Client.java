package io.codeforall.bootcamp;


public class Client implements Runnable{


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

    }
}
