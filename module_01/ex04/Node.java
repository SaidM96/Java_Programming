package ex04;

public class Node{
    Transaction value;
    Node next;
    Node prev;

    Node(Transaction v){
        this.value = v;
        this.next = null;
        this.prev = null;
    }
}