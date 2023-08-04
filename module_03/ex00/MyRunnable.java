package ex00;

public class MyRunnable implements Runnable{
    private int    count;
    public MyRunnable(int count){
        this.count = count;
    }
    public void run(){
        for(int i = 0; i < this.count; ++i){
            System.out.println("Hen");
        }
    }
}