package ex03;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Deque;

public class MyThread extends Thread{
    private int    id;
    private ClassFile fileWorkingOn;
    private static Deque<ClassFile> filesToDownload;
    private static FileDownloader Downloader = new FileDownloader();
    private static final Object lock = new Object();
    private static int threadsCounter = 1;

    public MyThread(int id, Deque<ClassFile> filesToDownload){
        this.id = id;
        this.fileWorkingOn = new ClassFile(0,"",Status.WaitingList);
        this.filesToDownload = filesToDownload;
    }
  
    public void run(){
        synchronized(lock){
            while(this.id != threadsCounter){
                try{
                    lock.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            threadsCounter++;
            lock.notifyAll();
        }
        int count = 0;
        while(true){
            synchronized(lock){
                for(ClassFile file : this.filesToDownload){
                    if (file.getStatus() == Status.WaitingList){
                        file.setStatus(Status.WorkingOn);
                        this.fileWorkingOn = file;
                        break ;
                    }
                }
                if (!this.fileWorkingOn.getUrl().equals("")){
                    System.out.println("Thread-" + this.id + " start download file number " + this.fileWorkingOn.getId());
                }
            }   
            if (!this.fileWorkingOn.getUrl().equals("")){
                this.Downloader.dowload(this.fileWorkingOn.getUrl());
                this.fileWorkingOn.setStatus(Status.FinishDownload);
                this.fileWorkingOn.setUrl("");
                System.out.println("Thread-" + this.id + " finish download file number " + this.fileWorkingOn.getId());
            }
            if(this.fileWorkingOn.getUrl().equals("")){
                for(ClassFile file : this.filesToDownload){
                    if (file.getStatus() == Status.WaitingList)
                        count++;
                }
                if (count == 0)
                    break ;
            }
            count = 0;
        }
    }
}
