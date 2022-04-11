import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CountCharacterTypes_04 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Path directory = Path.of("C:\\Users\\Desi\\IdeaProjects\\input.txt");
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(directory);
        } catch (Exception io) {
            System.out.println("Another error with reading file");
        }

        Map<String, Integer> symbols = new HashMap<>();
        symbols.put("vowels", 0);
        symbols.put("consonants", 0);
        symbols.put("punctuations", 0);

        for (String line : lines) {
            for (char symbol : line.toCharArray()) {
                if (symbol == ' ') {
                    continue;
                } else if (isVowel(symbol)) {
                    symbols.put("vowels", symbols.get("vowels") + 1);
                } else if (isPunctional(symbol)) {
                    symbols.put("punctuations", symbols.get("punctuations") + 1);
                } else {
                    symbols.put("consonants", symbols.get("consonants") + 1);
                }
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("output_task_4.txt"));
        writer.write("Vowels: " + symbols.get("vowels"));
        writer.newLine();
        writer.write("Consonants: " + symbols.get("consonants"));
        writer.newLine();
        writer.write("Punctuation: " + symbols.get("punctuations"));

        writer.close();
    }

    private static boolean isPunctional(char symbol) {
        return symbol == '!' || symbol == ',' || symbol == '.' || symbol == '?';
    }

    private static boolean isVowel(char symbol) {
        return symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u';
    }

}