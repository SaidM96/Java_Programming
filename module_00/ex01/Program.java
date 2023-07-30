import java.util.Scanner;

public class Program {

  public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int  num = 0;
      if (in.hasNextInt())
        num = in.nextInt();
      else{
        System.out.println("llegalArgument");
        System.exit(-1);
      }
      NumberPrime number = new NumberPrime(num);
      System.out.println(number.isPrime() + " " + number.getInstructions());
    }
}

public class NumberPrime{
    // 
    private int num, instractions;

    // constructor
    public NumberPrime(int num){
        if (num <= 1){
          System.out.println("llegalArgument");
          System.exit(-1);
        }
        this.num = num;
        this.instractions = 1; // for comparision with 1 
    }

    public  boolean isPrime(){
        int i = 5;

        // check if num is less than 3  or divisible by 2 or 3
        if (this.num <= 3){
          return true; 
        }
        this.instractions++;
        if (((this.num % 2) == 0)  || ((this.num % 3) == 0)){
          return false;
        }
        this.instractions++;
        // starts from i = 5, and we iterate through the odd numbers (6k ± 1) as potential divisors of n up to the square root
        // only need to check odd numbers (6k ± 1). In each iteration, 
        // and check if n is divisible by i or i + 2. If n is divisible by either of them, then it's not a prime number
        // and return False. The reason for using i + 2 is to cover the ±1 difference in the form 6k ± 1.
        while(this.num >= (i * i)){
          if (((this.num % i) == 0)  || (this.num % (i + 2) == 0))
            return false;
          this.instractions++;
          i += 6;
        }
        return true;
      }

    public int getNum(){
      return this.num;
    }
    public int getInstructions(){
      return this.instractions;
    }
}

