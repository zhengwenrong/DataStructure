package org.wenrong.linked;

import java.util.Objects;

/**
 * use linked to create a queue
 */
public class LinkedQueue {

    private Node headNode;
    private int size = 0;


    private class Node {
        private Node next;
        private int data;

        public Node(int data){

            this.data = data;
        }

    }

    public LinkedQueue(){

    }

    /**
     * return the queue is empty or not
     * @return
     */
    public boolean isEmpty(){

        return this.size == 0;
    }

    public void push(int data){

        if(this.size == 0){
            headNode = new Node(data);
        }else {
            Node node = new Node(data);
            node.next = headNode;
            headNode = node;
        }
        this.size++;
    }

    public int pop(){

        if(isEmpty())
            throw new RuntimeException("the queue is empty now,can't not pop any element");
        int data = headNode.data;
        headNode = headNode.next;
        return data;
    }

    @Override
    public String toString() {

        StringBuffer buffer = new StringBuffer();
        buffer.append("[");

        while (this.size != 0) {

            buffer.append(headNode.data);
            buffer.append(",");
            headNode = headNode.next;
            this.size--;
        }

        buffer.append("]");

        return buffer.toString();
    }


}
