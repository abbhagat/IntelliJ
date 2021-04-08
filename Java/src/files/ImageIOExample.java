package files;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageIOExample {

    public static void main(String[] args) {
        try {
            File file = new File("D:\\Java Study Materials\\1.jpg");
            BufferedImage image = ImageIO.read(file); // you can either use URL or File for reading image using ImageIO
            ImageIO.write(image, "jpg", new File("D:\\home_loan.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Success");
    }
}
