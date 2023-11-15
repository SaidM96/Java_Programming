package ex02;

public class Program{
    public static void main(String[] args){
        if (args.length != 1){
            System.out.println("Please provide exactly full path of current dir.");
            return ;
        }
        if (!args[0].contains("--current-folder=")){
            return ;
        }
        FileManager program = new FileManager();
        program.startProgram(args[0].replace("--current-folder=", ""));
    }
}