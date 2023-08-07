package ex00;

public class Printer{   
    private int[][] pixels;
    private String bg, it;
    private int size;

    public Printer(String bg, String it, int[][] pixels){
        this.size = 16;
        this.bg = bg;
        this.it = it;
        this.pixels = pixels;
    }

    public void printIt(){
        String line = new String("");
        for(int i = 0; i < this.size; ++i){
            line = "";
            for(int j = 0; j < this.size; ++j){
                line += (this.pixels[i][j] != -1) ? this.it : this.bg;
            }
            System.out.println(line);
        }
    }
}