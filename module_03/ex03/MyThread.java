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

    public MyThread(int id, Deque<ClassFile> filesToDownload){
        this.id = id;
        this.fileWorkingOn = new ClassFile("",Status.WaitingList);
        synchronized (lock) {
            this.filesToDownload = filesToDownload;
        }
    }

    public void run(){
        synchronized (lock) {
            while(true){
                for(ClassFile file : this.filesToDownload){
                    if (file.getStatus() == Status.WaitingList){
                        this.fileWorkingOn = file;
                        file.setStatus(Status.WorkingOn);
                    }

                }
                if (this.fileWorkingOn.getUrl().equals("")){
                    // Thread-1 start download file number 1
                    this.Downloader.dowload(this.fileWorkingOn.getUrl());
                    this.fileWorkingOn.setStatus(Status.FinishDownload);
                    this.fileWorkingOn.setUrl("");
                }
            }
        }
    }

}
