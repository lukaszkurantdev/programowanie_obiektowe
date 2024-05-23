package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RectangleController {
    List<Rectangle> rectangles = new ArrayList<>();

    @GetMapping("rectangle")
    public Rectangle getRectangle() {
        Rectangle rectangle = new Rectangle(
                20,10,
                100,213,
                "red");
        return rectangle;
    }

    @PostMapping("addRectangle")
    public int addRectangle() {
        Rectangle rectangle = new Rectangle(
                20,10,
                100,213,
                "red");

        rectangles.add(rectangle);

        return rectangles.size();
    }

    @GetMapping("rectangles")
    public List<Rectangle> getRectangles() {
        return rectangles;
    }
}
