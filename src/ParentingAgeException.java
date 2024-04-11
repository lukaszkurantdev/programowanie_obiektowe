import java.time.Period;

public class ParentingAgeException extends Exception {

    public final Person person;
    private static String personAndLifespan(Person person) {
        return String.format("%s (%s%s)", person.name, person.birth, person.death == null ? "" : " - y" + person.death);
    }
    public ParentingAgeException(Person person, Person parent) {
        super(String.format("It is hard to imagine that %s could be parent to %s.", personAndLifespan(parent), personAndLifespan(person)));
        this.person = person;
    }
}