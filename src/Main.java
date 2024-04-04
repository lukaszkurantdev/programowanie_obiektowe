import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PlantUMLRunner.setJarPath("plantuml-1.2024.3.jar");
//        PlantUMLRunner.generate(data, "uml", "test");

        try {
            List<Person> people = Person.fromCsv("family.csv");
            for(Person person: people)
                System.out.println(person);

            Person person = people.get(2);
            String uml = person.toUML();
            PlantUMLRunner.generate(uml, "uml", person.name);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}