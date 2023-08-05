package ex02;
import java.util.ArrayList;
import java.util.List;

public class MyThread extends Thread{
    private int    from;
    private int    to;
    private int    id;
    private int    sum;
    private boolean bool;
    private List<Integer> arr;
    private static final Object lock = new Object();
    private static int threadCounter = 0;
    public MyThread(int id, List<Integer> arr,int from, int to, boolean bool){
        this.from = from;
        this.to = to;
        this.id = id;
        this.sum = 0;
        this.arr = arr;
        this.bool = bool;
        // if (this.from >= this.arr.size() || this.to >= this.arr.size() )
        //     System.out.println("wazbi wazbi: " + this.id + " from: " + this.from + " to: " + this.to);
    }

    public void run(){
        synchronized (lock) {
            while (this.id != threadCounter + 1){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (this.bool){
                if (this.to == this.from)
                    System.out.println("Thread " + this.id + ": from " + this.from + " to " + this.to + " sum is " + 0);
                else{
                    // System.out.println("wazbi 2: " + this.id + " from: " + this.from + " to: " + this.to);
                    for(int i = this.from; i < this.to; ++i){
                        this.sum += arr.get(i);
                    }
                    System.out.println("Thread " + this.id + ": from " + this.from + " to " + this.to + " sum is " + this.sum);
                }
            }
            else {
                if (this.to == this.from)
                    System.out.println("Thread " + this.id + ": from " + this.from + " to " + this.to + " sum is " + 0);
                else{
                    for(int i = from; i <= this.to; ++i){
                        this.sum += arr.get(i);
                    }
                    System.out.println("Thread " + this.id + ": from " + this.from + " to " + this.to + " sum is " + this.sum);
                }
            }
            threadCounter++;
            lock.notifyAll();
        }
    }

    public int getSum(){
        return this.sum;
    }
}
