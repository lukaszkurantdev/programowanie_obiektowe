import java.util.Locale;

public class Ellipse extends Shape {
    private Point center;
    private double rx,ry;
    public Ellipse(Point center,double rx, double ry,Style style){
        super(style);
        this.center=center;
        this.rx=rx;
        this.ry=ry;
    }
    public String toSvg(){
        return String.format(Locale.ENGLISH,"<ellipse cx=\"%f\" cy=\"%f\" rx=\"%f\" ry=\"%f\"\n" +
                " %s />",center.x,center.y,rx,ry,style.toSvg());
    }

}