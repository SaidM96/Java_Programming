package ex02;
import java.util.ArrayList;
import java.util.List;

public class Program{
    public static void main(String[] args){
        // get arguments
        int sizeArray = Integer.parseInt(args[0]);
        int numThreads = Integer.parseInt(args[1]);

        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < sizeArray; i++){
            arr.add(1);
        }

        (double) pay = (double)sizeArray / (double)numThreads;
        if (pay < 1)

        if ((int) Math.ceil(pay) * sizeArray)
        int payThread = (int) Math.ceil(pay);
        System.out.println("pay double: " + pay);
        List<MyThread> threads = new ArrayList<>();
        for(int i = 0; i < numThreads; i += pay + 1){
            if (i == numThreads - 1)
                threads.add(new MyThread(i + 1,arr ,i , i + pay));
            else
                threads.add(new MyThread(i + 1,arr ,i , i + pay));
        }
        try {
            for(int i = 0; i < numThreads; ++i){
                threads.get(i).start();
                threads.get(i).join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int sum = 0;
        for(int i = 0; i < numThreads; i++){
            sum += threads.get(i).getSum();
        } 
        System.out.println("Sum by threads: " + sum);

        //
        // List<MyThread> threads = new ArrayList<>();
        // double pay = (double)sizeArray / (double)numThreads;
        // // int payThread = (int) (pay + 0.5);
        // int payThread = (int) Math.ceil((double)sizeArray / (double)numThreads);
        // int payLastTread = payThread * (numThreads) - sizeArray;
        // for(int i = 0; i < numThreads; ++i){
        //     if (i == numThreads - 1 && payLastTread > 0 ){
        //         int payto = ((i) * payThread) + payLastTread;
        //         threads.add(new MyThread(i + 1, i * payThread, (payto == sizeArray ? payto - 1 : payto) , payThread - payLastTread));
        //     }
        //     else
        //         threads.add(new MyThread(i + 1, i * payThread, ((i + 1) * payThread) - 1, payThread));
        // }
        // try {
        //     for(int i = 0; i < numThreads; ++i){
        //         threads.get(i).start();
        //         threads.get(i).join();
        //     }
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
    }
}