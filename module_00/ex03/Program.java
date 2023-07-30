import java.util.Scanner;

public class Program {

  public static void main(String[] args) {
    int hold_min_grade = -1;
    int num = 0;
    String WeekStr = new String("Week");
    list statics = new list();   
    Scanner in = new Scanner(System.in);
    for(int week = 1; week <= 18; week++){
        String lineWeek = in.nextLine();
        if (lineWeek.length() == 2 && lineWeek.indexOf("42") == 0){
            statics.printStatics();
            return ;
        }
        String[] str = lineWeek.split(" ", 2);
        if (!(str.length == 2 && (str[0].equals(WeekStr) && Integer.parseInt(str[1]) == week))){
            new err();
        }
        String lineNumbers = in.nextLine();
        String[] numbers  = lineNumbers.split(" ");
        if (numbers.length != 5)
            new err();
        for(int i = 0; i < numbers.length; i++){
            num = Integer.parseInt(numbers[i]);
            if (num < 1 || num > 9)
                new err();
            if (hold_min_grade == -1 || num < hold_min_grade)
                hold_min_grade = num;
        }
        statics.insert(hold_min_grade);
        hold_min_grade = -1;
    }
    statics.printStatics();
}}


public class node{
    public int value;
    node next;

    node(int v){
        this.value = v;
        this.next = null;
    }
}

public class list{
    node head;

    public list(){
        this.head = null;
    }

    public void insert(int num){
        node newNode = new node(num);
        if (this.head == null){
            this.head = newNode;
            return ;
        }
        node tmp = this.head;
        while(tmp != null){
            if (tmp.next == null){
                tmp.next = newNode;
                break ;
            }
            tmp = tmp.next;
        }
    }

    private String visualize(int grade){
        String result = "";
        if (grade < 1)
            return result;
        while(grade != 0){
            result += "=";
            grade--;
        }
        result += ">";
        return result;
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

public class err{
    public err(){
        System.err.println("llegalArgument");
        System.exit(-1);
    }
}