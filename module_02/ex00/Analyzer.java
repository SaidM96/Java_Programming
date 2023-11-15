package ex00;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Analyzer {
    private Map<String, String> fileSignatures; // signature key , fileEXtention value
    private List<String> result;
    
    public Analyzer(){
        this.fileSignatures = new HashMap<>();
        this.result = new ArrayList<>();
        this.fillMap();
    }

    // read signature.txt and fill map with key: hexSignature , value: {signatureLength} {separator: !} {extention name}
    private void fillMap(){
        try{
            // Step 1: Open the file for reading
            FileInputStream fis = new FileInputStream("/goinfre/smia/Java_Programming/module_02/ex00/signatures.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = new String("");
            String[] params = new String[2];
            while((line = br.readLine()) != null){
                params = line.split(",");
                String signature = params[1].replace(" ","");
                fileSignatures.put(signature, signature.length() + "!" + params[0]);
            }
        }
        catch(Exception e){
            //
        }
    }

    
    // check file path if exist and take first 8 bbytes from it that represent hexSignature 
    // send that signature to function signatureChecker to decide if that signature is valid file extention
    
    public boolean checkPath(String path){
        try{
            InputStream inputStream = new FileInputStream(path);
            byte[] buffer = new byte[8]; // Buffer to hold the first 8 bytes
            int bytesRead = inputStream.read(buffer);
            if (bytesRead == 8) {
                StringBuilder hexSignature = new StringBuilder();
                for (byte b : buffer) {
                    hexSignature.append(String.format("%02X", b));
                }
                String signature = hexSignature.toString();
                if (!this.signatureChecker(signature)){
                    this.result.add("UNDEFINED");
                }
                System.out.println("PROCESSED");
                return true;
            }
            return false;
        }
        catch(Exception e){
            System.out.print(e);
            return false;
        }
    }
    
    private boolean signatureChecker(String sign){
        for (Map.Entry<String, String> entry : fileSignatures.entrySet()) {
                String fileExt = entry.getValue();
                String[] params = fileExt.split("!");
                String Mysignature = entry.getKey().substring(0,Integer.parseInt(params[0]));
                if (Mysignature.equals(sign.substring(0, Mysignature.length()))){
                    this.result.add(params[1]);
                    return true;    
                }
        }
        return false;
    }


    private String resultToString(){
        String result = new String("");
        for (String file : this.result) {
            result += file + "\n";
        }
        return result;
    }


    public void generateResultFile(){
        String fileName = "result.txt"; // Replace this with your desired file name
        String currentDirectory = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String content = this.resultToString();
        try (FileOutputStream fos = new FileOutputStream(currentDirectory  + separator + "ex00" + separator + fileName)) {
            byte[] bytes = content.getBytes();
            fos.write(bytes);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}