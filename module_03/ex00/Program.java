package ex00;

public class Program{
    public static void main(String[] args){
        int count = Integer.parseInt(args[0]);
        MyThread thread1 = new MyThread(count);
        MyRunnable runnable = new MyRunnable(count);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        try {
            thread1.join(); // Wait for thread1 to complete
            thread2.join(); // Wait for thread2 to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < count; ++i){
            System.out.println("Human");
        }
    }
}