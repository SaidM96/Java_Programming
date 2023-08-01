package ex01;

public class Program{
    public static void main(String[] args){
        Dictionary dictionary = new Dictionary();
        dictionary.FillDictionary("/goinfre/smia/Java_Programming/module_02/ex01/said1", "/goinfre/smia/Java_Programming/module_02/ex01/said2");
        double similarity = dictionary.claculeSimilarity();
        System.out.println("Similarity = " + similarity);
    }
}