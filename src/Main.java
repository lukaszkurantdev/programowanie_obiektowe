

//https://github.com/lukaszkurantdev/programowanie_obiektowe

public class Main {
    public static void main(String[] args) {
        Style style = new Style("lime", "red", null);
        Point point1 = new Point(100, 0);
        Point point2 = new Point(50, 100);
        Point point3 = new Point(150, 100);

        Polygon polygon = new Polygon(3, style);
        polygon.setPoint(0, point1);
        polygon.setPoint(1, point2);
        polygon.setPoint(2, point3);

        SvgScene svgScene = new SvgScene();
        svgScene.addPolygon(polygon);
        svgScene.saveHtml("./test.html");

    }
}