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

    public void increaseBrightness(int factor) {
        for(int x = 0 ; x < image.getHeight() ; x++) {
            for(int y = 0 ; y < image.getWidth() ; y++) {
                int pixel = image.getRGB(x, y);
                pixel = brightenPixel(pixel, factor);
                image.setRGB(x, y, pixel);
            }
        }
    }

    private int brightenPixel(int pixel, int factor) {
        int mask = 255;
        int blue = pixel & mask;
        int green = (pixel >> 8) & mask;
        int red = (pixel >> 16) & mask;
        blue = brightenPixelPart(blue, factor);
        green = brightenPixelPart(green, factor);
        red = brightenPixelPart(red, factor);
        return blue + (green << 8) + (red << 16);
    }

    private int brightenPixelPart(int color, int factor) {
        color += factor;
        if(color > 255) {
            return 255;
        } else {
            return color;
        }
    }
}
