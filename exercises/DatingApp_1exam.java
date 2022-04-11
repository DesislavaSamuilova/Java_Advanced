import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class DatingApp_1exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> males = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(males::push);
        ArrayDeque<Integer> females = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(females::offer);

        int match = 0;


        while (!males.isEmpty() && !females.isEmpty()) {
            int firstSum = females.peek();
            int secondSum = males.peek();
            if (firstSum <= 0) {
                females.poll();
                continue;
            }
            if (secondSum <= 0) {
                males.pop();
                continue;
            }
            if (firstSum % 25 == 0) {
                females.poll();
                females.poll();
                continue;
            }
            if (secondSum % 25 == 0) {
                males.pop();
                males.pop();
                continue;
            }
            if (firstSum == secondSum) {
                match++;
                females.poll();
                males.pop();
            } else {
                females.poll();
                males.push(males.pop() - 2);
            }

        }
        System.out.printf("Matches: %d", match);
        System.out.println();
        if (males.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: " + males.stream().map(String::valueOf)
            .collect(Collectors.joining(", ")));
            System.out.println();
        }
        if (females.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: " + females.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));        }
    }
}
