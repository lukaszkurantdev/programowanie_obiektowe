import java.util.Locale;

public class Polygon {
    private Point[] arr;
    Style style;

    public Polygon(int count, Style style) {
        arr = new Point[count];
        this.style = style;
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


}
