public class UndefinedParentException extends Exception {
    public UndefinedParentException(Person person, String parentName) {
        super(String.format("Referenced parent of the person %s not found: %s", person.name, parentName));
    }
}