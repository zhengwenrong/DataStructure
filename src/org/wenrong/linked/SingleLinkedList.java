package org.wenrong.linked;

/**
 * 带头结点单链表
 */
public class SingleLinkedList {

    //头结点
    private Node head = new Node();

    public void add(int  data){

        Node tailNode = getTailNode();
        Node newNode = new Node();
        newNode.data =data;
        tailNode.next = newNode;

    }

    public int get(int index){

        Node node = head;

        int i = 0;

        while(node.next != null){

            node = node.next;

            if(i == index){

                return node.data;
            }
            i++;
        }

        throw new RuntimeException("index not found");
    }


    public int delete(int index){

        Node node = head;

        int i = 0;
        Integer data = 0;
        Node preNode = null;

        while(node.next != null){

            node = node.next;

            if(i == index -1){

                preNode = node;

            }

            if(i == index){
                if(preNode != null){
                    preNode.next = node.next;
                    data = node.data;
                    node = null;
                }

                return data;
            }
            i++;
        }

        throw new RuntimeException("index not found");
    }

    /**
     * 获取尾部节点
     * @return
     */
    private Node getTailNode(){

        Node node = head;

        while(node.next != null){

            node = node.next;

        }

        return node;
    }


    @Override
    public String toString() {

        Node node = head.next;
        StringBuffer buffer = new StringBuffer();
        if(node == null){
            //空链表
            buffer.append("[]");

        }else {

            buffer.append("[");
            while(node != null && node.next != null){
                buffer.append(node.data);
                node = node.next;
                buffer.append(",");
            }

            buffer.append(node.data);
            buffer.append("]");

        }



        return buffer.toString();
    }
}

class Node {

    public Node next;
    public int data;

    public Node(){}

    public Node(Node next,int data){
        this.next = next;
        this.data = data;
    }

}

