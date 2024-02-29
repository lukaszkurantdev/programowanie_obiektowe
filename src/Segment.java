import java.util.Locale;

public class Segment {
    private Point p1, p2;

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }
// https://github.com/lukaszkurantdev/programowanie_obiektowe
    public Segment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double getDistance(){
        return Math.hypot(p1.x - p2.x, p1.y - p2.y);
    }

    public String toSvg() {
        return String.format(Locale.ENGLISH,"<line x1=\"%f\" y1=\"%f\" x2=\"%f\" " +
                "y2=\"%f\" style=\"stroke:red;stroke-width:2\" />", p1.x,
                p1.y, p2.x, p2.y
        );
    }
}
