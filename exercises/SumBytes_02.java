import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.readAllBytes;

public class SumBytes_02 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String directory = "C:\\Users\\Desi\\IdeaProjects\\input.txt";

        long sum = 0;
        for (byte value : readAllBytes(Path.of(directory))) {
            if (value != 10 && value != 13) {
                sum += value;
            }
        }
        System.out.println(sum);
    }
}
