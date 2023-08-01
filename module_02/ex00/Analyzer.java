package ex00;
import java.util.Map;
import java.util.HashMap;

public class Analyzer {
    private String path;
    private Map<String, String> fileSignatures; // signature key , fileEXtention value
    
    private fillMap(){
        
    }
    
    public Analyzer(String path){
        this.path = path;
        this.fileSignatures = new HashMap<>();
        this.fillMap();
    }
}