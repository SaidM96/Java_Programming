import java.util.Scanner;

public class Program {

  public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      String line = in.nextline();

    }
}

public class node{
    char c;
    int count;
    node next;

    node(char v){
        this.c = v;
        this.count = 1;
        this.next = null;
    }

    public increment(){
        this.count++;
    }
}

public class list{
    node head;

    public list(){
        this.head = null;
    }

    public void insert(char c){
        node newNode = new node(c);
        if (this.head == null){
            this.head = newNode;
            return ;
        }
        node tmp = this.head;
        while(tmp != null){
            if (tmp.c == newNode.c){
                tmp.increment();
                break ;
            }
            if (tmp.next == null){
                tmp.next = newNode;
                break ;
            }
            tmp = tmp.next;
        }
    }



    private String visualize(){
        
    }

    public void printStatics(){
        node tmp = this.head;
        int week = 1;
        while(tmp != null){
            System.out.println("Week " + week + " " + this.visualize(tmp.value));
            tmp = tmp.next;
            week++;
        }
    }
}