import java.util.Scanner;

public class Program {

  public static void main(String[] args) {
    int numbers[] = new int[100];
    int count = 0;
    int index = 0;
    Scanner in = new Scanner(System.in);
    while(index < 100){
      if (in.hasNextInt())
        numbers[index] = in.nextInt();
      else{
        System.out.println("llegalArgument");
        System.exit(-1);
      }
      if (numbers[index] == 42){
        if (index == 0){
          System.out.println("Count of coffee-request - 0");
          System.exit(0);
        }
        index++;
        break ;
      }
      index++;
    }
    for(int i = 0; index > i; i++){
        NumberPrime number = new NumberPrime(numbers[i]);
        if (number.isPrime())
            count++;
    }
    System.out.println("Count of coffee-request : " + count);
    }
}

public class NumberPrime{
    // 
    private int num, instractions;

    // constructor
    public NumberPrime(int num){
        this.num = num;
    }

    public void sumDigits(){
        int number = this.num;
        int result = 0;
        while(number != 0){
            result += number % 10;
            number /= 10;
        }
        this.num = result;
    }

    public  boolean isPrime(){
        int i = 5;
        if (this.num <= 1)
            return false;
        this.sumDigits();
        if (this.num <= 3){
          return true; 
        }
        if (((this.num % 2) == 0)  || ((this.num % 3) == 0)){
          return false;
        }
        while(this.num >= (i * i)){
          if (((this.num % i) == 0)  || (this.num % (i + 2) == 0))
            return false;
          i += 6;
        }
        return true;
      }

    public int getNum(){
      return this.num;
    }
}