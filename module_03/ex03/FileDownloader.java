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
                URL url = new URL(this.urlStr);
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                
                byte[] buffer = new byte[1024];
                int bytesRead;
                
                FileOutputStream outputStream = new FileOutputStream("downloaded_image.png");
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                
                outputStream.close();
                inputStream.close();
                
                System.out.println("File downloaded and saved as: " + "downloads");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}