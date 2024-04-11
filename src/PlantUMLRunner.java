import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PlantUMLRunner {
    private static String jarPath;

    public static void setJarPath(String jarPath) {
        PlantUMLRunner.jarPath = jarPath;
    }

    public static void generate(String data, String path, String fileName) {
        try {
            File catalog = new File(path);
            catalog.mkdirs();

            String filePath = path + '/' + fileName + ".txt";
            FileWriter writer = new FileWriter(filePath);
            writer.write(data);
            writer.close();

            ProcessBuilder builder = new ProcessBuilder(
                    "java",
                    "-jar",
                    PlantUMLRunner.jarPath,
                    filePath
            );
            Process process = builder.start();
            process.waitFor();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
