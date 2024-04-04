import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String data = "@startuml\n" +
                "object JanKowalski\n" +
                "object AnnaKowalska\n" +
                "\n" +
                "JanKowalski --> AnnaKowalska\n" +
                "@enduml";

        PlantUMLRunner.setJarPath("plantuml-1.2024.3.jar");
        PlantUMLRunner.generate(data, "uml", "test");
//        try {
//            List<Person> people = Person.fromCsv("family.csv");
//            for(Person person: people)
//                System.out.println(person);
//
//            Person.toBinaryFile(people, "family.bin");
//            List<Person> loadPeople = Person.fromBinaryFile("family.bin");
//            for(Person person: loadPeople)
//                System.out.println(person);
//
//        } catch (IOException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }
}