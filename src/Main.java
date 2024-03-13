

//https://github.com/lukaszkurantdev/programowanie_obiektowe

public class Main {
    public static void main(String[] args) {
        Style style = new Style("lime", "red", null);
        Point point1 = new Point(0, 100);
        Point point2 = new Point(100, 102);

        Segment line = new Segment(point1, point2);
        Polygon polygon = Polygon.sqare(line, style);

        Ellipse ellipse = new Ellipse(new Point(150, 200), 20, 30, style);

        SvgScene svgScene = new SvgScene();
        svgScene.addShape(polygon);
        svgScene.addShape(ellipse);
        svgScene.saveHtml("./test.html");
    }
}