package org.wenrong.queue;

/**
 * 使用数组实现队列
 */
public class ArrayQueue {

    public static void main(String[] args) {

        Queue queue = new Queue(5);
        queue.push(2);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(2);
        queue.pop();

        System.out.println(queue);


    }


    static class Queue {

        private int head;
        private int maxSize;
        private int tail;
        private int[] queue;

        public Queue(int capacity){
            if(capacity <= 0){
                throw  new IllegalArgumentException("queue capacity can't not be less than zero");
            }
            queue = new int[capacity];
            head = 0;
            tail = -1;
            maxSize = capacity;
        }

        /**
         *  return the queue is empty or not
         * @return
         */
        public boolean isEmpty(){

            return head == tail;
        }

        /**
         * return the queue is full or not
         * @return
         */
        public boolean isFull(){

            return tail == maxSize -1;
        }

        /**
         * add the element to the queue
         * @param data
         * @return
         */
        public boolean push(int data){

            if(isFull()){
                throw new RuntimeException("queue is full now,can't not push any element");
            }

            queue[++tail] = data;

            return true;
        }

        /**
         * pop the head element from the queue
         * @returnh
         */
        public int pop(){

            if(isEmpty()){

                throw  new RuntimeException("queue is empty now,cat't pop any element from the queue ");
            }

            int element = queue[++head];
            return element;
        }

        /**
         * get head element from the queue
         * @return
         */
        public int getHeadElement(){

            if(isEmpty()){

                throw  new RuntimeException("queue is empty now,cat't pop any element from the queue ");
            }

            int temp = head;
            int element = queue[--temp];
            return element;

        }

        @Override
        public String toString() {

            StringBuffer buffer = new StringBuffer();
            buffer.append("[");
            for(int i = head;i <= tail;i++){

                buffer.append(queue[i]);
                if(i != tail){
                    buffer.append(",");
                }

            }

            buffer.append("]");

            return buffer.toString();
        }
    }

}
