package ex01;

public class Node{
    int count;
    String value;
    Node next;

    public Node(String v){
        this.value = v;
        this.count = 1;
        this.next = null;
    }

    public void increment(){
        this.count++;
    }
}