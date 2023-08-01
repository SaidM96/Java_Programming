package ex00;
import java.util.Scanner;

public class Program{
    public static void main(String[] args){
        Analyzer analyzer = new Analyzer();
        Scanner in = new Scanner(System.in);
        while(true){
            String line = in.nextLine();
            if (line.length() == 2 && line.indexOf("42") == 0){
                analyzer.generateResultFile();
                break ;
            }
            if (!analyzer.checkPath(line))
                break ;
        }
    }
}