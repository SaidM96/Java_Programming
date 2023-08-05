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

        int payRegular = (int) Math.floor((double)sizeArray / (double)numThreads);
        int payLast = sizeArray - payRegular * (numThreads - 1);
        if (payRegular < payLast){
            payRegular = (int) Math.ceil(((double)sizeArray / (double)numThreads));
            payLast = sizeArray - payRegular * (numThreads - 1);
        }
        System.out.println("pay regular: " + payRegular + " pay last: " + payLast);
        List<MyThread> threads = new ArrayList<>();
        int j = 0;
        boolean bool = false;
        int max = sizeArray - 1;
        for(int i = 0; i < numThreads; ++i){
            if (sizeArray <= numThreads){
                threads.add(new MyThread(i + 1, arr ,j , j + payRegular, true));
            }
            else if (bool)
                threads.add(new MyThread(i + 1,arr ,max, max, false));
            else if (i == numThreads - 1)
                threads.add(new MyThread(i + 1, arr ,j , j + payLast - 1, false));
            else{
                threads.add(new MyThread(i + 1, arr ,j , j + payRegular - 1, false));
                if (j + payRegular == sizeArray){
                    bool = true;
                    max = j + payRegular - 1;
                }
                    
            }
            j += payRegular;
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