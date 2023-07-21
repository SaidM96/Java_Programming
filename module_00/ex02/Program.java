import java.util.Scanner;

public class Program {

  public static void main(String[] args) {
    int numbers[] = new int[100];
    int count = 0;
    int max_size = 1000;
    int index = 0;
    while(true){
      Scanner in = new Scanner(System.in);
      numbers[index] = in.nextInt();
      if (numbers[index] == 42){
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
        // check if num is less than 3  or divisible by 2 or 3
        if (this.num <= 3){
          return true; 
        }
        if (((this.num % 2) == 0)  || ((this.num % 3) == 0)){
          return false;
        }
        // starts from i = 5, and we iterate through the odd numbers (6k ± 1) as potential divisors of n up to the square root
        // only need to check odd numbers (6k ± 1). In each iteration, 
        // nad check if n is divisible by i or i + 2. If n is divisible by either of them, then it's not a prime number
        // and return False. The reason for using i + 2 is to cover the ±1 difference in the form 6k ± 1.
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