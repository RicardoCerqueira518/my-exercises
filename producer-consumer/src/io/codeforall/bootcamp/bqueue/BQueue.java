package io.codeforall.bootcamp.bqueue;

import java.util.LinkedList;

/**
 * Blocking Queue
 * @param <T> the type of elements stored by this queue
 */
public class BQueue<T> {

    private int limit;
    private final LinkedList<T> queue = new LinkedList<>();

    /**
     * Constructs a new queue with a maximum size
     * @param limit the queue size
     */
    public BQueue(int limit) throws UnsupportedOperationException{
            this.limit = limit;
    }

    /**
     * Inserts the specified element into the queue
     * Blocking operation if the queue is full
     * @param data the data to add to the queue
     */
    public synchronized void offer(T data) throws InterruptedException {
        while (queue.size() == limit) {
            System.out.println("Queue is full. Producer is waiting...");
            wait(); // Wait until space is available
        }
        queue.add(data);
        System.out.println("Produced: " + data);
        notifyAll(); // Notify consumers that new data is available
    }

    /**
     * Retrieves and removes data from the head of the queue
     * Blocking operation if the queue is empty
     * @return the data from the head of the queue
     */
    public synchronized T poll() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Queue is empty. Consumer is waiting...");
            wait(); // Wait until there is data to consume
        }
        T data = queue.removeFirst();
        notifyAll(); // Notify producers that space is available
        return data;
    }

    /**
     * Gets the number of elements in the queue
     * @return the number of elements
     */
    public int getSize() {
        return queue.size();
    }

    /**
     * Gets the maximum number of elements that can be present in the queue
     * @return the maximum number of elements
     */
    public int getLimit() {
        return limit;
    }

}
