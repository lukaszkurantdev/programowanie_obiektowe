public class AmbiguousPersonException extends Exception {
    private final String name;

    public AmbiguousPersonException(String name) {
        super("Found more than one person with the name: " + name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}