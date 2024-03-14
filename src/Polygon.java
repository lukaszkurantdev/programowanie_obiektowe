import java.util.Locale;

public class Polygon implements Shape {
    private Vec2[] arr;
    private Style style;

    public Polygon(int count, Style style) {
        this.style = style;
        arr = new Vec2[count];
    }

    public void setPoint(int index, Vec2 point) {
        arr[index] = point;
    }

    public void setPoints(Vec2[] points){
        arr = points;
    }

    public String toSvg(String parameters) {
        String pointsString = "";
        for(Vec2 point : arr)
            pointsString += point.x + "," + point.y + " ";

        return String.format(Locale.ENGLISH,"" +
                "<polygon points=\"%s\" %s />", pointsString, parameters);
    }

    static Polygon sqare(Segment line, Style style) {
        double x = (line.getP1().x + line.getP2().x) / 2;
        double y = (line.getP1().y + line.getP2().y) / 2;
        Vec2 center = new Vec2(x, y);
        Segment[] secondLine = Segment.perpendicular(line, center, line.getDistance() / 2);

        Polygon polygon = new Polygon(4, style);
        polygon.setPoint(0, line.getP1());
        polygon.setPoint(1, secondLine[0].getP2());
        polygon.setPoint(2, line.getP2());
        polygon.setPoint(3, secondLine[1].getP2());

        return polygon;
    }

}
