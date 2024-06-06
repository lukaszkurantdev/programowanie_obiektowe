package com.example.demo;

import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
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
    public int addRectangle(@RequestBody Rectangle rectangle) {
        rectangles.add(rectangle);

        return rectangles.size();
    }

    @GetMapping("rectangles")
    public List<Rectangle> getRectangles() {
        return rectangles;
    }

    @GetMapping("rectangle/{id}")
    public Rectangle getRectangle(@PathVariable Long id) throws IOException {
        byte[] photo = Base64.getDecoder().decode("asdhsdahjdb37dn3ybnhsdj")
        BufferedImage bf = ImageIO.read(
                new ByteArrayInputStream(photo)
        );
        ///...
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(bf, "png", stream);
        byte[] photo2 = stream.toByteArray();
        String result = Base64.getEncoder().encodeToString(photo2);
        return rectangles.get(id.intValue());
    }

}
