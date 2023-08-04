package ex00;

public class MyThread extends Thread{
    private int    count;
    public MyThread(int count){
        this.count = count;
    }
    public void run(){
        for(int i = 0; i < this.count; ++i){
            System.out.println("Egg");
        }
    }
}