package org.wenrong.stack;

import org.wenrong.linked.DoubleLinkedList;

/**
 * 使用链表实现栈
 */
public class LinkedStack {

    DoubleLinkedList linkedList = new DoubleLinkedList();
    int top = -1;
    public void push(int data){

        linkedList.add(data);
        top++;
    }

    public boolean isEmpty(){

        return top==-1;
    }

    public int pop(){

        DoubleLinkedList.Node nodeAt = linkedList.getNodeAt(top);

        linkedList.delete(top);
        top--;
        return nodeAt.getData();
    }

    public static void main(String[] args) {

        LinkedStack linkedStack = new LinkedStack();

        for(int i = 0; i < 10 ; i ++){

            linkedStack.push(i);

        }

        while (!linkedStack.isEmpty()){

            System.out.println(linkedStack.pop());

        }

    }

}
