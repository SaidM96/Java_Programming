import java.util.Scanner;
public class Program {
  public static void main(String[] args) {
    try{
    while(true){
      Scanner in = new Scanner(System.in);
      int number = in.nextInt();
      System.out.println(number);
    }
    }catch(Exception e){
      System.out.println("zbi");
    }
  }
}