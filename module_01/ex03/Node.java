package ex03;

public class Node{
    Transaction value;
    Node next;

    Node(Transaction v){
        this.value = v;
        this.next = null;
    }
}