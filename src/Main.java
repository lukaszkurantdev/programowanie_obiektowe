import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String path = "zgony.csv";

        try {

           List<DeathCauseStatistics> list = Files.lines(Paths.get(path))
                    .skip(2)
                    .map(v -> DeathCauseStatistics.fromCsvLine(v))
                    .collect(Collectors.toList());
"test".split(" ", 2)
           int age = 32;
           List<DeathCauseStatistics> result = list.stream().sorted(
                   (x,y) -> Integer.compare(
                           y.bracketDeaths(age).deathCount,
                           x.bracketDeaths(age).deathCount
                   )
           ).collect(Collectors.toList()).subList(0,10);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


