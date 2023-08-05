package ex01;

public class Program{
    public static void main(String[] args){
        int count = Integer.parseInt(args[0]);
        MyThread thread1 = new MyThread(count, "Hgg");
        MyThread thread2 = new MyThread(count, "Hen");
        thread1.start();
        thread2.start();
        try {
            thread1.join(); 
            thread2.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}