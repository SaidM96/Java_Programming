package fr.my.printer;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ReadBMPImage {
    
    public ReadBMPImage(){

    }

    public int[][] getPixelColors(){
            int[][] pixelColors = new int[16][16];
            try {
                // Load the BMP image
                File imageFile = new File("/goinfre/smia/zbi/module_04/ex00/ImagesToChar/src/resources/it.bmp");
                BufferedImage image = ImageIO.read(imageFile);
                // Get image dimensions
                int width = 16;
                int height = 16;
                // Create a 2D array to store the RGB values of each pixel
                for (int y = 0; y < height; y++) {
                    for (int x = 0; x < width; x++) {
                        // Get the RGB value of the pixel at (x, y)
                        int rgb = image.getRGB(x, y);
                        pixelColors[y][x] = rgb;
                    }
                }
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
            return pixelColors;
    }
    
}