package org.wenrong.queue;

import java.util.Arrays;

public class CircleArrayQueue {

    private int capacity;
    private int head;
    private int tail;
    private int[] queue;

    public CircleArrayQueue(int capacity){
        this.capacity = capacity;
        queue = new int[capacity];
    }

    public void push(int data){

        if(isFull()){
            throw new RuntimeException("queue is full now！");
        }
        queue[tail] = data;
        tail = (tail + 1)%capacity;
    }

    public int pop(){

        if(isEmpty()){
            throw new RuntimeException("queue is empty now！");
        }

        int data = queue[head];
        head = (head+1)%capacity;

        return data;
    }

    public boolean isFull(){

        return (tail + 1)%capacity == head;
    }

    public boolean isEmpty(){

        return head==tail;
    }

    public int getQueueSize(){
        return (tail + capacity - head) % capacity;
    }

    @Override
    public String toString() {

        int temHead = head;
        int temTail = tail;

        int[] arr = new int[getQueueSize()];
        int i = 0;
        while(temHead != temTail){

            arr[i++] = queue[temHead];
            temHead = (temHead + 1) % capacity;

        }

        return Arrays.toString(arr);
    }
}
