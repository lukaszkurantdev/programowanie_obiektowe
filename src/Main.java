

//https://github.com/lukaszkurantdev/programowanie_obiektowe

public class Main {
    public static void main(String[] args) {
        Vec2 point1 = new Vec2(0, 100);
        Vec2 point2 = new Vec2(100, 102);
        Vec2 point3 = new Vec2(50, 50);

        Polygon polygon = new Polygon(
                3,
                new Style(null, null, null)
        );
        polygon.setPoint(0, point1);
        polygon.setPoint(1, point2);
        polygon.setPoint(2, point3);

        Shape filledPolygon = new SolidFilledShapeDecorator(polygon, "blue");

        Shape transformedPolygon = new TransformationDecorator
                .Builder()
                .setShape(filledPolygon)
                .setTranslateVector(point3)
                .setTranslateVector(point3)
                .build();

        SvgScene svgScene = new SvgScene();
        svgScene.addShape(transformedPolygon);
        svgScene.saveHtml("./test.html");
    }
}