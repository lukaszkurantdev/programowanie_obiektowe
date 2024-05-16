package pl.umcs.oop;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessor {
    private BufferedImage image;

    public void loadImage(String path) throws IOException {
        File file = new File(path);
        image = ImageIO.read(file);

//        image.getWidth()
//        int pixel = image.getRGB(0,0);
//        image.setRGB(0,0,20);
    }

    public void saveImage(String path) throws IOException {
        File file = new File(path);
        ImageIO.write(image, "png", file);
    }
}
