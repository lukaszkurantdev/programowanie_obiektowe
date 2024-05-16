package pl.umcs.oop;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ImageProcessor ip = new ImageProcessor();
        try {
            ip.loadImage("image.png");
            ip.increaseBrightness(100);
            ip.saveImage("image2.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}