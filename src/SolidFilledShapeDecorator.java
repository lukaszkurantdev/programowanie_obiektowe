import java.util.Locale;

public class SolidFilledShapeDecorator extends ShapeDecorator {
    private String color;


    public SolidFilledShapeDecorator(Shape decoratedShape, String color) {
        super(decoratedShape);
        this.color = color;
    }

    @Override
    public String toSvg(String parameters) {
        return super.toSvg(
                String.format(Locale.ENGLISH,
                        "fill=\"%s\" %s ", color, parameters)
        );
    }
}
