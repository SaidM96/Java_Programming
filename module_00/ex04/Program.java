import java.util.Scanner;

public class Program {

  public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      String line = in.nextLine();
      char[] charArray = line.toCharArray();
      list data = new list();
      for(int i = 0; i < charArray.length; i++){
        data.insert(charArray[i]);
      }
      data.visualize();
    }
}

public class node{
    char c;
    boolean bool;
    int count;
    node next;

    node(char v){
        this.c = v;
        this.count = 1;
        this.next = null;
        this.bool = false;
    }

    public void increment(){
        this.count++;
    }
}

public class list{
    node head;
    double moyen;
    int size;
    public list(){
        this.moyen = 0;
        this.size = 0;
        this.head = null;
    }

    public void insert(char c){
        node newNode = new node(c);
        if (this.head == null){
            this.head = newNode;
            this.size++;
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
                this.size++;
                break ;
            }
            tmp = tmp.next;
        }
    }

    private node find_next_max_count(){
        node tmp = this.head;
        node maxNode = null;
        int cmp = -1;
        while(tmp != null){
            if (!tmp.bool && (cmp == -1 || tmp.count > cmp)){
                cmp = tmp.count;
                maxNode = tmp;
            }
            tmp = tmp.next;
        }
        if (maxNode == null)
            return null;
        maxNode.bool = true;
        return maxNode;
    }

    private String fill_arrow(node Node){
        int i = 1;
        String arrow = new String("");
        arrow += Node.count;
        int count  = (int)((double)(Node.count  * 10 ) / this.moyen);
        while(i <= count){
            arrow += "#";
            ++i;
        }
        arrow += Node.c;
        return arrow;
    }

    public void visualize(){
        String[] graph = new String[this.size];
        int i = 0;
        node nextMax = this.find_next_max_count();
        if (nextMax == null)
            return ;
        this.moyen = nextMax.count;
        // System.out.println(nextMax.c + " " + nextMax.count);
        while(nextMax != null){
            graph[i] = this.fill_arrow(nextMax);
            System.out.println(graph[i]);
            nextMax = this.find_next_max_count();
            i++;
        }
        // render graph
        // int j = graph[0].length();
        // String line = new String("");
        // for(int nline = 0; i < 10; nline++){
        //     j--;
        //     for(int index = 0; i < graph.length && j > 0; index++){
        //         if (j < graph[index].length())
        //             line += graph[index].charAt(j);
        //         // System.out.println(graph[index].charAt(j));
        //     }
        //     System.out.println(line);
        //     line = "";
        // }
    }

    public void display_list(){
        node Node = this.head;
        while(Node != null){
            System.out.println(Node.c + " " + Node.count);
            Node = Node.next;
        }
    }
}