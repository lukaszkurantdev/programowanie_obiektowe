import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordBag {
    private List<String> words = new ArrayList<>();
    private Random rand = new Random();


    public void populate() {
        String path = "slowa.txt";
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            words = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get() {
        return words.get(rand.nextInt(words.size()));
    }


}
