import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class Person {

    public String name;
    public LocalDate birthDate;
    public LocalDate deathDate;

    public static Person fromCsvLine(String line){

        String[] splited = line.split(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate bDate = LocalDate.parse(splited[1], formatter);
        Person person = new Person();
        person.name = splited[0];
        person.birthDate = bDate;

        if(!splited[2].isEmpty()) {
            LocalDate dDate = LocalDate.parse(splited[2], formatter);
            person.deathDate = dDate;
        }

        return person;

    }

    public static List<Person> fromCsv(String path) throws IOException {
        ArrayList<Person> list = new ArrayList<>();
        FileReader fileReader = new FileReader(path);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = reader.readLine();
        line = reader.readLine();
        while(line != null)
        {
            Person person = fromCsvLine(line);
            try {
                person.checkAmbiguousPersonException(list);
                person.checkLifespan();
            } catch (NegativeLifespanException | AmbiguousPersonException e) {
               System.out.println(e.getMessage());
            }

            list.add(person);

            line = reader.readLine();
        }
        return list;
    }

    public void checkLifespan() throws NegativeLifespanException {
        if(deathDate != null && deathDate.isBefore(birthDate)) {
            throw new NegativeLifespanException(this);
        }
    }

    public void checkAmbiguousPersonException(List<Person> list) throws AmbiguousPersonException {
        for(Person person: list) {
            if(person.name.equals(this.name)) {
                throw new AmbiguousPersonException(this);
            }
        }
    }

}
