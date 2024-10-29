package io.codeforall.bootcamp;

import io.codeforall.bootcamp.bqueue.Pizza;
import io.codeforall.bootcamp.bqueue.BQueue;

/**
 * Consumer of integers from a blocking queue
 */
public class Consumer implements Runnable {

    private final BQueue<Pizza> queue;
    private int elementNum;


    /**
     * @param queue the blocking queue to consume elements from
     * @param elementNum the number of elements to consume
     */
    public Consumer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < elementNum; i++) {
                Pizza pizza = queue.poll();
                System.out.println("Consumed: " + pizza);
                Thread.sleep(1500); // Simulate time taken to consume
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

}