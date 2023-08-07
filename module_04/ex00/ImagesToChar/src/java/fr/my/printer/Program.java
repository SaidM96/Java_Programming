package fr.my.printer;


public class Program {
    public static void main(String[] args){
        String bg = args[0];
        String it = args[1];

        ReadBMPImage readerImage = new ReadBMPImage();
        int[][] pixels = readerImage.getPixelColors();
        Printer printer = new Printer(bg,it,pixels);
        printer.printIt();
    }
}