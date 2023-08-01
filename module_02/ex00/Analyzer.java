package ex00;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
public class Analyzer {
    private Map<String, String> fileSignatures; // signature key , fileEXtention value
    private List<String> result;
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
    
    public Analyzer(){
        this.fileSignatures = new HashMap<>();
        this.result = new ArrayList<>();
        this.fillMap();
    }

    private boolean signatureChecker(String sign){
        String result = new String("");
        for (Map.Entry<String, String> entry : fileSignatures.entrySet()) {
                String fileExt = entry.getValue();
                String[] params = fileExt.split("!");
                String Mysignature = entry.getKey().substring(0,Integer.parseInt(params[0]));
                if (Mysignature.equals(sign.substring(0, Mysignature.length()))){
                    this.result.add(params[1]);
                    System.out.println("PROCESSED");
                    return true;
                }
            }
        return false;
    }

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
                    System.out.println("UNDEFINED");
                }
                else
                    return true;
            }
            return false;
        }
        catch(Exception e){
            System.out.print(e);
            return false;
        }
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
        String content = this.resultToString();

        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            byte[] bytes = content.getBytes();
            fos.write(bytes);
            System.out.println("File created and data written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}