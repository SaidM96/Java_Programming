package ex01;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Iterator;

public class Dictionary{
    private LinkedList data1;
    private LinkedList data2;
    private TreeSet<String> dictionary;
    private List<Integer> vec1;
    private List<Integer> vec2;
    
    
    public Dictionary(){
        this.data1 = new LinkedList();
        this.data2 = new LinkedList();
        this.dictionary = new TreeSet<>();
        this.vec1 = new ArrayList<>();
        this.vec2 = new ArrayList<>();
    }

    public double claculeSimilarity(){
        int Numerator = 0;
        int Denominator = 0;
        int v1carre = 0;
        int v2carre = 0;
        for(int i = 0; i < this.vec1.size(); i++){
            Numerator += this.vec1.get(i) * this.vec2.get(i);
            v1carre += this.vec1.get(i) * this.vec1.get(i);
            v2carre += this.vec2.get(i) * this.vec2.get(i);
        }
        return (Numerator / (Math.sqrt(v1carre) * Math.sqrt(v2carre)));
    }


    public void FillDictionary(String fileName1, String fileName2){
        try{
            {
                BufferedReader reader = new BufferedReader(new FileReader(fileName1));
                String line;
                while ((line = reader.readLine()) != null){
                    String[] words = line.split(" ");
                    for(int i = 0; i < words.length; ++i){
                        this.data1.insert(words[i]);
                        if (!this.dictionary.contains(words[i]))
                            this.dictionary.add(words[i]);

                    }
                }
            }
            {   
                BufferedReader reader = new BufferedReader(new FileReader(fileName2));
                String line;
                while ((line = reader.readLine()) != null){
                    String[] words = line.split(" ");
                    for(int i = 0; i < words.length; ++i){
                        this.data2.insert(words[i]);
                        if (!this.dictionary.contains(words[i]))
                            this.dictionary.add(words[i]);
                    }
                }
            }
            {
                Iterator<String> iterator = this.dictionary.iterator();
                while (iterator.hasNext()) {
                    String word = iterator.next();
                    int num1 = this.data1.cordVector(word);
                    int num2 = this.data2.cordVector(word);
                    this.vec1.add(num1);
                    this.vec2.add(num2);
                }
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }



}