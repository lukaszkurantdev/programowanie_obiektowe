public abstract class Shape {
    protected Style style;

    public Shape(Style style) {
        this.style = style;
    }

    public abstract String toSvg();
}
