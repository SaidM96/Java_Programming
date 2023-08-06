package ex03;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class FileDownloader {
        private String urlStr;
        
        public FileDownloader(){
            this.urlStr = "";
        }


        public void dowload(String urlStr){
                try {  
                    URL url = new URL(urlStr);
                    URLConnection connection = url.openConnection();
                    InputStream inputStream = connection.getInputStream();
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    String fileName = urlStr.substring(urlStr.lastIndexOf('/') + 1);
                    FileOutputStream outputStream = new FileOutputStream(fileName);
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    outputStream.close();
                    inputStream.close();
                }
                catch (IOException e) {
                e.printStackTrace();
            }
        }
}