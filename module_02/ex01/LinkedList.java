package ex01;


public class LinkedList{
    Node  head;
    int   size;

    public LinkedList(){
        this.size = 0;
        this.head = null;
    }

    public void insert(String c){
        Node newNode = new Node(c);
        if (this.head == null){
            this.head = newNode;
            this.size++;
            return ;
        }
        Node tmp = this.head;
        while(tmp != null){
            if (tmp.value.equals(newNode.value)){
                tmp.increment();
                break ;
            }
            if (tmp.next == null){
                tmp.next = newNode;
                this.size++;
                break ;
            }
            tmp = tmp.next;
        }
    }


    public int cordVector(String word){
        Node tmp = this.head;
        while(tmp != null){
            if (tmp.value.equals(word))
                return tmp.count;
            tmp = tmp.next;
        }
        return 0;
    }

}