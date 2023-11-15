package ex01;

public class Program{
    public static void main(String[] args){
        // check if args just 2
        if (args.length != 2){
            System.out.println("Please provide exactly two file paths.");
            return ;
        }
        Dictionary dictionary = new Dictionary();
        dictionary.FillDictionary(args[0], args[1]);
        double similarity = dictionary.claculeSimilarity();
        String formattedSimilarity = String.format("%.2f", similarity);
        System.out.println("Similarity = " + formattedSimilarity);
    }
}