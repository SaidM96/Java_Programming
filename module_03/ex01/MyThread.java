package ex01;

public class MyThread extends Thread{
    private int    count;
    private String message;
    private static Object lock = new Object();

    public MyThread(int count, String message){
        this.count = count;
        this.message = message;
    }

    public void run(){
        for(int i = 0; i < this.count; ++i){
            synchronized (lock){    
                lock.notify(); // Notify the other thread
                try {
                    lock.wait(); // Wait for the other thread to notify
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}