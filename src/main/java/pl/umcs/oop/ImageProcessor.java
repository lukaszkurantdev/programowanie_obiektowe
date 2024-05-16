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
        for(int x = 0 ; x < image.getWidth(); x++) {
            for(int y = 0 ; y < image.getHeight() ; y++) {
                int pixel = image.getRGB(x, y);
                pixel = brightenPixel(pixel, factor);
                image.setRGB(x, y, pixel);
            }
        }


    }
    public void increaseBrightnessThreads(int factor) throws InterruptedException {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("test");
        Thread threads[] = new Thread[availableProcessors];
        for(int i = 0; i < threads.length; i++)
        {
            final int finalI = i;
            threads[i] = new Thread(() -> {
                int start = image.getHeight() * finalI / availableProcessors;
                int end = start + image.getHeight() / availableProcessors;
                System.out.println(finalI);
                if(finalI == availableProcessors - 1)
                {
                    end = image.getHeight();
                }
                for(int x = start ; x < end ; x++) {
                    for(int y = 0 ; y < image.getWidth() ; y++) {
                        int pixel = image.getRGB(x, y);
                        pixel = brightenPixel(pixel, factor);
                        image.setRGB(x, y, pixel);
                    }
                }
            });
            threads[i].start();
        }
        for(int i = 0; i < threads.length; i++)
        {
            threads[i].join();
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
