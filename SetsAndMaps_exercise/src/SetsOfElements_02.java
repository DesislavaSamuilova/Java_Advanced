import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Integer> first = new LinkedHashSet<>();
        LinkedHashSet<Integer> second = new LinkedHashSet<>();
        String input = scanner.nextLine();
        int n = Integer.parseInt(input.split("\\s+")[0]);
        int m = Integer.parseInt(input.split("\\s+")[1]);
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            first.add(number);
        }
        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            second.add(number);
        }
        LinkedHashSet<Integer> duplicatedElements = new LinkedHashSet<>();
        for (int number : first) {
            if (second.contains(number)) {
                duplicatedElements.add(number);
            }
        }
        duplicatedElements.forEach(number -> System.out.print(number + " "));
    }
}
