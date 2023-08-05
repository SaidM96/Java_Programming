package ex02;
import java.util.ArrayList;
import java.util.List;

public class MyThread extends Thread{
    private int    from;
    private int    to;
    private int    id;
    private int    sum;
    private List<Integer> arr;

    public MyThread(int id, List<Integer> arr,int from, int to){
        this.from = from;
        this.to = to;
        this.id = id;
        this.sum = 0;
        this.arr = arr;
    }

    public void run(){
            for(int i = from; i < this.to; ++i){
                this.sum += arr.get(i);
            }
            System.out.println("Thread " + this.id + ": from " + this.from + " to " + this.to + " sum is " + this.sum);
    }

    public int getSum(){
        return this.sum;
    }
}
