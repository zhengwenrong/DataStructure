package org.wenrong.linked;

public class App {

    public static void main(String[] args) {

        SingleLinkedList linkedList = new SingleLinkedList();

        for(int i = 0;i < 10;i++){

            linkedList.add(i);
        }

        System.out.println(linkedList.delete(5));
        System.out.println(linkedList);
    }

}
