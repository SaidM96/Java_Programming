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
        if (params.length != 2){
            System.err.println("llegalArgument");
            System.exit(-1);
        }
        int time = Integer.parseInt(params[0]);
        String dayName =  params[1];
        int day = users.getNUmDayByDay(dayName, 0);
        if (day < 1 || !(time >= 1 && time <= 6)){
              System.err.println("llegalArgument");
              System.exit(-1);
        }
        ClassTime newClass = new ClassTime(time, dayName, day);
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
        if (params.length != 4){
            System.err.println("llegalArgument");
            System.exit(-1);
        }
        String name = params[0];
        int time = Integer.parseInt(params[1]);
        int day = Integer.parseInt(params[2]);
        String isHere =  params[3];
        boolean wasHere = isHere.equals("HERE");
        if ((day < 1 || day > 30) || !(time >= 1 && time <= 6) || (!wasHere && !isHere.equals("NOT_HERE"))){
              System.err.println("llegalArgument");
              System.exit(-1);
        }
        Abscence obj = new Abscence();
        String dayName =  users.getDayByNumDay(day);
        obj.setValues(time, day, dayName, wasHere);
        users.addAbscence(name, obj);
        abs[count] = obj;
        count++;
      }
      // get first line table (times)
      classes = users.generateFirstLine(classes, sizeClasses);
        // render table 
      users.renderStudentLines(classes);
    }
    // 
}

  public class ClassTime{
      int     time;
      String  dayName;
      int     day;
      boolean bool;

      public ClassTime(){
        this.time = 0;
        this.dayName = "";
        this.day = 0;
        bool = false;
      }
      public ClassTime(int time, String dayName, int day){
        this.time = time;
        this.dayName = dayName;
        this.day = day;
        bool = false;
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
      int sizeC;
      String[] days ={"TU", "WE", "TH", "FR", "SA", "SU","MO"};

      public List(){
          this.head = null;
          this.size = 0;
          this.sizeC = 0;
      }

      public  String getDayByNumDay(int day){
          return this.days[(day - 1) % 7];
      }

      public int getNUmDayByDay(String day, int weekNum){
        for(int i = 0; i < days.length; i++){
            if (this.days[i].equals(day))
              return (i + 1 + 7 * weekNum);
        }
        return 0;
      }

      // public boolean minClass(ClassTime class1, ClassTime class2){
      //   int d1 = this.getNUmDayByDay(class1.dayName,0);
      //   int d2 = this.getNUmDayByDay(class2.dayName,0);
      //   if ((d1 == d2))
      //     return (class1.time < class2.time);
      //   return (d1 < d2);
      // }

      public ClassTime takeMinClass(ClassTime[] classes, int sizeClass){
          ClassTime holdSmaler = new ClassTime(0,"",0);
          int holdIndex = -1;
          for(int i = 0; i < sizeClass; ++i){
              if (!classes[i].bool && ((classes[i].day == holdSmaler.day && classes[i].time < holdSmaler.time) || (classes[i].day < holdSmaler.day || holdSmaler.day == 0))){
                holdSmaler = classes[i];
                holdIndex = i;
              }
          }
          classes[holdIndex].bool = true;
          return classes[holdIndex];
      }

      public ClassTime[] sortClass(ClassTime[] classes, int sizeClass){
        ClassTime[] classTimes = new ClassTime[10];
        for(int i = 0; i < sizeClass; ++i){
            classTimes[i] = takeMinClass(classes,sizeClass);
        }
        return classTimes;
      }

      public void renderStudentLines(ClassTime[] classes){
        Node tmp = this.head;
        String lineStudent = new String("");
        boolean bool = true;
        while(tmp != null){
          lineStudent += tmp.value.getName();
          for(int j = 0; j < this.sizeC; j++){
              bool = true;
              for(int i = 0; i < tmp.value.sizeArr; ++i){
                    if (tmp.value.abscences[i].time == classes[j].time && tmp.value.abscences[i].day == classes[j].day){
                      if (classes[j].day > 9)
                        lineStudent += " ";
                      if (tmp.value.abscences[i].wasHere)
                        lineStudent += "        1|";
                      else
                        lineStudent += "       -1|";
                      bool = false;
                    }
              }
              if (bool){
                if (classes[j].day > 9)
                    lineStudent += " ";
                lineStudent += "         |";
              }
          }
          System.out.println(lineStudent);
          lineStudent = "";
          tmp = tmp.next;
        }
      }

      public  ClassTime[] generateFirstLine(ClassTime[] classes, int sizeClass) { 
          ClassTime[] classTimes = new ClassTime[10];
          ClassTime[] resultClass = new ClassTime[10];
          String firstLine = new String("  ");
          int count = 0;
          classTimes = this.sortClass(classes,sizeClass);
          for(int j = 0; j <= 4; j++){
            for(int i = 0; i < sizeClass && (classTimes[i].day + (7 * j)) < 31 && count < 10; ++i){
              firstLine += " " + classTimes[i].time + ":00 " + classTimes[i].dayName + " " + (classTimes[i].day + (7 * j))  + "|";
            resultClass[count] = new ClassTime(classTimes[i].time, classTimes[i].dayName, classTimes[i].day + (7 * j));
            count++;
          }
        }
        this.sizeC = count;
        System.out.println(firstLine);
        return resultClass;
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
