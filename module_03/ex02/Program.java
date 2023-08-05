package ex02;
import java.util.ArrayList;
import java.util.List;

public class Program{
    public static void main(String[] args){
        // get arguments
        int sizeArray = Integer.parseInt(args[0]);
        int numThreads = Integer.parseInt(args[1]);
        int random = 1;
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < sizeArray; i++){
            arr.add(random);
        }

        int payRegular = (int) Math.floor((double)sizeArray / (double)numThreads);
        int payLast = sizeArray - payRegular * (numThreads - 1);
        if (payRegular < payLast){
            payRegular = (int) Math.ceil(((double)sizeArray / (double)numThreads));
            payLast = sizeArray - payRegular * (numThreads - 1);
        }

        // System.out.println("pay regular: " + payRegular + " pay last: " + payLast);
        List<MyThread> threads = new ArrayList<>();
        int j = 0;
        boolean bool = false;
        int max = sizeArray - 1;
        if (sizeArray <= numThreads)
        {
            for(int i = 0; i < numThreads; ++i){
                if (bool)
                    threads.add(new MyThread(i + 1,arr ,max, max, true));
                else
                    threads.add(new MyThread(i + 1, arr ,j , j + 1, true));
                if (j == sizeArray - 1){
                        bool = true;
                        max = j + 1;
                }
                j++;
            }
        }
        else{
            for(int i = 0; i < numThreads; ++i){
                if (!bool && (sizeArray <= j + payRegular - 1) && (i != numThreads - 1)){
                    bool = true;
                    payLast = ((sizeArray) - (j));
                    max = j  + payLast - 1;
                    // System.out.println("pay last: " + payLast + " from: " + (j  - 1) + " max: " + max);
                    threads.add(new MyThread(i + 1, arr ,j  - 1 , max, true));
                }
                else if (bool)
                    threads.add(new MyThread(i + 1,arr ,max, max, false));
                else if (i == numThreads - 1)
                    threads.add(new MyThread(i + 1, arr ,j , j + payLast - 1, false));
                else{
                    threads.add(new MyThread(i + 1, arr ,j , j + payRegular - 1, false));
                    // System.out.println("wazbi99  i: " + (i + 1) + " next: " + (j + payRegular - 1));
                    if (j + payRegular == sizeArray){
                        bool = true;
                        max = j + payRegular - 1;
                    }
                }
                j += payRegular;
            }
        }
        
        try {
            for(int i = 0; i < numThreads; ++i){
                threads.get(i).start();
            }
            for(int i = 0; i < numThreads; ++i){
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
    }
}