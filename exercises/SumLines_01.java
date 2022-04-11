import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class SumLines_01 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
       // String directory = "C:\\Users\\Desi\\OneDrive - Software University (SoftUni)\\Работен плот\\input.txt";
        String path = "C:\\Users\\I353529\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";

        //str -> str.toCharArray
        for (String s : Files.readAllLines(Path.of(path))) {
            char[] charArray = s.toCharArray();
            int sum = 0;
            for (char symbol : charArray) {
                sum += symbol;
            }
            System.out.println(sum);
        }
    }
}