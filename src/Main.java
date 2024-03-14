

//https://github.com/lukaszkurantdev/programowanie_obiektowe

public class Main {
    public static void main(String[] args) {
        Vec2 point1 = new Vec2(0, 100);
        Vec2 point2 = new Vec2(100, 102);
        Vec2 point3 = new Vec2(50, 50);

        SolidFilledPolygon solidFilledPolygon = new SolidFilledPolygon(3, "red");
        solidFilledPolygon.setPoint(0, point1);
        solidFilledPolygon.setPoint(1, point2);
        solidFilledPolygon.setPoint(2, point3);

        SvgScene svgScene = new SvgScene();
        svgScene.addShape(solidFilledPolygon);
        svgScene.saveHtml("./test.html");
    }
}