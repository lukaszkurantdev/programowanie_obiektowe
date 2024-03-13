import java.util.Locale;

public class Polygon extends Shape {
    private Point[] arr;


    public Polygon(int count, Style style) {
        super(style);
        arr = new Point[count];
    }

    public void setPoint(int index, Point point) {
        arr[index] = point;
    }

    public void setPoints(Point[] points){
        arr = points;
    }

    public String toSvg() {
        String pointsString = "";
        for(Point point : arr)
            pointsString += point.x + "," + point.y + " ";

        return String.format(Locale.ENGLISH,"" +
                "<polygon points=\"%s\"%s />", pointsString, style.toSvg());
    }

    static Polygon sqare(Segment line, Style style) {
        double x = (line.getP1().x + line.getP2().x) / 2;
        double y = (line.getP1().y + line.getP2().y) / 2;
        Point center = new Point(x, y);
        Segment[] secondLine = Segment.perpendicular(line, center, line.getDistance() / 2);

        Polygon polygon = new Polygon(4, style);
        polygon.setPoint(0, line.getP1());
        polygon.setPoint(1, secondLine[0].getP2());
        polygon.setPoint(2, line.getP2());
        polygon.setPoint(3, secondLine[1].getP2());

        return polygon;
    }

}
