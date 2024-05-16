package pl.umcs.oop;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ImageProcessor ip = new ImageProcessor();

        try {
            long start1 = System.currentTimeMillis();
            ip.loadImage("test.png");
            ip.increaseBrightness(100);
            ip.saveImage("test2.png");
            long end1 = System.currentTimeMillis();

//            long start2 = System.currentTimeMillis();
//            ip.loadImage("test.png");
//            ip.increaseBrightnessThreads(100);
////            ip.saveImage("test2.png");
//            long end2 = System.currentTimeMillis();
//            System.out.println(end1 - start1);
//            System.out.println(end2 - start2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

//        ExecutorService executor = Executors.newFixedThreadPool(12);
//
//        executor.execute(() -> {
//            //obliczenia
//        });
//        executor.execute(() -> {
//            //obliczenia
//        });
//        executor.shutdown();
//
//        if(executor.isTerminated()) {
//
//        }

        CategoryChart chart =
                new CategoryChartBuilder()
                        .width(800)
                        .height(600)
                        .xAxisTitle("Score")
                        .yAxisTitle("Number")
                        .build();

        // Customize Chart
        chart.getStyler().setLabelsVisible(false);
        chart.getStyler().setPlotGridLinesVisible(false);

        // Series
        chart.addSeries("test 1", Arrays.asList(0, 1, 2, 3, 4), Arrays.asList(4, 5, 9, 6, 5));
        new SwingWrapper<>(chart).displayChart();
    }
}