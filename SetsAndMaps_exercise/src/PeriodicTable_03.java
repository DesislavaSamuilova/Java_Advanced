import javax.lang.model.util.Elements;
import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        TreeSet<String> elements = new TreeSet<>();
        for (int i = 0; i < number; i++) {
            String input = scanner.nextLine();
            String [] inputElements = input.split("\\s+");

            elements.addAll(Arrays.asList(inputElements));
        }
        elements.forEach(el -> System.out.print(el + " "));
    }
}
