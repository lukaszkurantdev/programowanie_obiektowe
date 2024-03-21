import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {

    public String name;
    public LocalDate birthDate;
    public LocalDate deathDate;

    public static Person fromCsvLine(String line){

        String[] splited = line.split(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate bDate = LocalDate.parse(splited[1], formatter);

        LocalDate dDate = LocalDate.parse(splited[1], formatter);
        Person person = new Person();
        person.name = splited[0];
        person.birthDate = bDate;
        if(splited[2] != null)
            person.deathDate = dDate;

        return person;

    }


}
