package io.codeforall.bootcamp;

public class LinkedList {

    private Node head;
    private int length = 0;

    public LinkedList() {
        this.head = new Node(null);
    }

    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list
     * @param data the element to add
     */
    public void add(Object data)  {

        Node node = new Node(data);
        Node iterator = head;
        while (iterator.getNext() != null){
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     * @param index the index of the element
     * @return the element
     */
    public Object get(int index) {

        if(length == 0) {
            return null;
        }

        Node node = head.getNext();

        for (int i = 0; i< length; i++) {
            if(index == i) {
                return node.getData();
            }
            node = node.getNext();
        }


        return null;
    }

    /**
     * Returns the index of the element in the list
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(Object data) {
        Node iterator = head;
        int count = 0;

      while (iterator.getNext() != null){
          iterator = iterator.getNext();
          if(iterator.getData() != data){
              count++;
              continue;
          }
          return count;
      }
        return -1;
    }

    /**
     * Removes an element from the list
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(Object data) {

        Node previousIterator = head;
        Node iterator = head;

        while(iterator.getNext() != null){
            iterator = iterator.getNext();
            if(data == iterator.getData()){
                previousIterator.setNext(iterator.getNext());
                length--;
                return true;
            }
            previousIterator = previousIterator.getNext();
        }
        return false;
    }

    private class Node {

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            next = null;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
