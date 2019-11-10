package org.wenrong.linked;

/**
 * 双向链表实现
 */
public class DoubleLinkedList {

    Node headNode = new Node();

    private Node getLastNode(){

        Node node = headNode;

        while(node.next != null){

            node = node.next;

        }

        return node;
    }


    public void add(int data){

        Node node = getLastNode();

        Node newNode = new Node(data);
        node.next = newNode;
        newNode.pre = node;
    }

    private int size(){

        Node node = headNode;
        int size = 0;

        while(node.next != null){
            node = node.next;
            size++;

        }
        return size;
    }

    private Node getNodeAt(int index){

        int size = size();

        if(index < 0 || index > size()){

            throw new IllegalArgumentException("index illegal!");
        }

        Node node = headNode.next;

        int i = 0;
        while(node!=null){

            if(i == index)
                break;

            node = node.next;
            i++;
        }

        return node;
    }

    public int delete(int index){

        Node nodeAt = getNodeAt(index);

        nodeAt.pre.next = nodeAt.next;
        nodeAt.next.pre = nodeAt.pre;

        int data = nodeAt.data;
        nodeAt = null;

        return data;
    }

    @Override
    public String toString() {

        String buffer = "[";

        Node node = headNode.next;
        while(node!= null){
            buffer += node.data;
            buffer += ",";
            node = node.next;
        }

        if(size() > 0)
            buffer = buffer.substring(0,buffer.lastIndexOf(","));

        buffer += "]";

        return buffer;
    }

    public static void main(String[] args) {

        DoubleLinkedList list = new DoubleLinkedList();
        for(int i = 0; i < 5 ; i++){
            list.add(i);
        }
        list.delete(0);
        list.delete(2);
        System.out.println(list);

    }

    class Node {

        Node next;
        Node pre;
        int data;

        public Node(){}

        public Node(int data){
            this.data = data;
        }

    }
}



