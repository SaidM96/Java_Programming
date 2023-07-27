import java.util.Scanner;

public class Program {
  public static void main(String[] args) {
      int phase = 0;
      int max = 10;
      List users = new List();
      ClassTime[] classes = new ClassTime[10];
      Abscence[] abs = new Abscence[10];
      int sizeClasses = 0;
      
      // phase 1
      while(true){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if (line.equals(".") || users.size() >= 10)
          break ;
        User newUser = new User(line);
        users.insert(newUser);
      }
      // phase 2
      while(true){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if (line.equals(".") || sizeClasses >= 10)
          break ;
        String[] params = line.split(" ");
        int time = Integer.parseInt(params[0]);
        String dayName =  params[1];
        ClassTime newClass = new ClassTime(time, dayName);
        classes[sizeClasses] = newClass;
        sizeClasses++;
      }
      // phase 3
      while(true){
        int count = 0;
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if (line.equals(".") || count >= 10)
          break ;
        String[] params = line.split(" ");
        String name = params[0];
        int time = Integer.parseInt(params[1]);
        int day = Integer.parseInt(params[2]);
        String isHere =  params[3];
        boolean wasHere = isHere.equals("HERE");
        Abscence obj = new Abscence();
        String dayName =  users.getDayByNumDay(day);
        obj.setValues(time, day, dayName, wasHere);
        // abs[count].setValues(time, day, dayName, wasHere);
        users.addAbscence(name, obj);
        count++;
      }
      // get first line table (times)
      String fline = users.generateFirstLine(classes,abs, sizeClasses);
      // render table 
      System.out.println(fline);
    }
    // 
}

    public class ClassTime{
      int    time;
      String dayName;

      public ClassTime(int time, String dayName){
        this.time = time;
        this.dayName = dayName;
      }
    }
    public class TimeTable{
      int    time;
      String dayName;
      int    day;

      public TimeTable(int time, String dayName, int day){
        this.time = time;
        this.dayName = dayName;
        this.day = day;
      }
    }

    public class Abscence{
      int             time;
      int             day;
      String          dayName;
      boolean         wasHere;

      public Abscence(){
        this.time = 0;
        this.day = 0;
        this.dayName = "";
        this.wasHere = false;
      }

      public void setValues(int time, int day, String dayName, boolean wasHere){
        this.time = time;
        this.day = day;
        this.dayName = dayName;
        this.wasHere = wasHere;
      }
    }
    
     public class User {
      String       name;
      Abscence[]   abscences;
      int sizeArr;

      public User(String name){
        this.abscences = new Abscence[10];
        this.name = name;
        this.sizeArr = 0;
      }

      public String getName(){
          return this.name;
      }

      public void addAbscence(Abscence obj){
          this.abscences[this.sizeArr] = obj;
          this.sizeArr++;
      }

      public int sizeArr(){
          return this.sizeArr;
      }

    }



    public class Node{
      User value;
      Node next;

      public Node(User v){
          this.value = v;
          this.next = null;
      }
    }

    public class List{
      Node head;
      int size;

      public List(){
          this.head = null;
          this.size = 0;
      }

      public  String getDayByNumDay(int day){
          String[] days ={"TU", "WE", "TH", "FR", "SA", "SU","MO"};
          return days[(day - 1) % 7];
      }

      public  String generateFirstLine(ClassTime[] classes, Abscence[] absences, int sizeClass) { 
          return "";
      }

      public void addAbscence(String name, Abscence obj){
          Node tmp = this.head;
          while(tmp != null){
              if (tmp.value.getName().equals(name)){
                  tmp.value.addAbscence(obj);
                  break ;
              }
              tmp = tmp.next;
          }
      }

      public void insert(User user){
          Node newNode = new Node(user);
          this.size++;
          if (this.head == null){
              this.head = newNode;
              return ;
          }
          Node tmp = this.head;
          while(tmp != null){
              if (tmp.next == null){
                  tmp.next = newNode;
                  break ;
              }
              tmp = tmp.next;
          }
      }

      public User[] toArray(){
        Node tmp = this.head;
        User[] users = new User[this.size];
        int i = 0;
        while(tmp != null && i < this.size){
          users[i] = tmp.value;
          tmp = tmp.next;
          i++;
        }
        return users;
      }


      public int size(){
        return this.size;
      }
  }
