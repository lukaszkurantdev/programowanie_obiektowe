package pl.umcs.oop;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ImageProcessor ip = new ImageProcessor();

        try {
            long start1 = System.currentTimeMillis();
            ip.loadImage("image.png");
            ip.increaseBrightness(100);
            ip.saveImage("image2.png");
            long end1 = System.currentTimeMillis();

            long start2 = System.currentTimeMillis();
            ip.loadImage("image.png");
            ip.increaseBrightnessThreads(100);
            ip.saveImage("image2.png");
            long end2 = System.currentTimeMillis();
            System.out.println(end1 - start1);
            System.out.println(end2 - start2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        Thread thread1 = new Thread(() -> {
//           //obliczenia
//        });
//        Thread thread2 = new Thread(() -> {
//            //obliczenia
//        });
//        thread1.start();
//        thread2.start();
//
//        thread1.join();
//        thread2.join();
       System.out.println(Runtime.getRuntime().availableProcessors());
        System.currentTimeMillis();

    }
}