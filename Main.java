import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File file = new File("image.png");
        ImageIcon imageIcon = new ImageIcon("image.png");


        for (int i = 0; i < imageIcon.getIconWidth(); i++) {
            System.out.println();
            for (int j = 0; j < imageIcon.getIconHeight(); j++) {
                System.out.print(getPixelColor(file,j,i));
            }
        }
    }

    public static String getPixelColor(File file, int x, int y) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Getting pixel color by position x and y
        int clr = image.getRGB(x, y);
        int red = (clr & 0x00ff0000) >> 16;
        int green = (clr & 0x0000ff00) >> 8;
        int blue = clr & 0x000000ff;
        if (red == 0 && green == 0 && blue == 0){
            return "-";
        } else if (red == 255 && green == 255 && blue == 255){
            return "*";
        } else {
return "#";}
    }
}
