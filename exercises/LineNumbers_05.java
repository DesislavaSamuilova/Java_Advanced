import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class LineNumbers_05 {
    public static int countRow = 1;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String directory = "C:\\Users\\Desi\\IdeaProjects\\input.txt";
        String outputPath = "outputLine.txt";
        PrintWriter writer = new PrintWriter(outputPath);

        Files.readAllLines(Path.of(directory))
                .forEach(line ->
                        writer.println(countRow++ + ". " + line));

        writer.close();
    }
}
