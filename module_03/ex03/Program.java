package ex03;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ArrayList;
import java.util.List;

public class Program{
    public static void main(String[] args){
        int numThreads = Integer.parseInt(args[0]);
        FileDownloader Downloader = new FileDownloader();
        String fileName = " files_urls.txt";
        String textToWrite =   "https://i.pinimg.com/originals/11/19/2e/11192eba63f6f3aa591d3263fdb66bd5.jpg\n" +
                               "https://pluspng.com/img-png/balloon-hd-png-balloons-png-hd-2750.png\n" +
                               "https://i.pinimg.com/originals/db/a1/62/dba162603c71cac00d3548420c52bac6.png\n"+
                               "https://pngimg.com/uploads/balloon/balloon_PNG4969.png\n"+
                               "http://tldp.org/LDP/intro-linux/intro-linux.pdf";
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(textToWrite);
            fileWriter.close();
            System.out.println("Text written to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        Deque<ClassFile> filesToDownload = new ArrayDeque<>();
        String[] files = textToWrite.split("\n");
        for(int i = 0; i < files.length; ++i){  
            filesToDownload.addLast(new ClassFile(files[i], Status.WaitingList));
        }
        // start dowload
        List<MyThread> threads = new ArrayList<>();

        for(int i = 0; i < numThreads; ++i){
            threads.add(new MyThread(i + 1, filesToDownload));
        }

        for(int i = 0; i < numThreads; ++i){
            threads.get(i).start();
        }
    }
}