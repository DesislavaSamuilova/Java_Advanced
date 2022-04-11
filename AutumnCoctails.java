import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class AutumnCoctails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(ingredients::offer);
        ArrayDeque<Integer> freshness = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(freshness::push);

        int pearSour = 0;
        int harvest = 0;
        int aplleHinny = 0;
        int highFishion = 0;

        while (!ingredients.isEmpty() && !freshness.isEmpty()) {
            int firstSum = ingredients.peek();
            int secondSum = freshness.peek();
            int sum = firstSum * secondSum;
            if (firstSum == 0) {
                ingredients.poll();
                continue;
            }
            if (sum == 150) {
                pearSour++;
                ingredients.poll();
                freshness.pop();
            } else if (sum == 250) {
                harvest++;
                ingredients.poll();
                freshness.pop();
            } else if (sum == 300) {
                aplleHinny++;
                ingredients.poll();
                freshness.pop();
            } else if (sum == 400) {
                highFishion++;
                ingredients.poll();
                freshness.pop();
            } else {
                freshness.pop();
                ingredients.poll();
                ingredients.addLast(firstSum + 5);
            }
        }
        if (pearSour >= 1 && harvest >= 1 && aplleHinny >= 1 && highFishion >= 1) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredients.isEmpty()) {
            int sum = 0;
            for (int num : ingredients) {
                sum += num;
            }
            System.out.printf("Ingredients left: %d%n", sum);
        }

        if (aplleHinny >= 1) {
            System.out.printf(" # Apple Hinny --> %d%n", aplleHinny);
        }
        if (highFishion >= 1) {
            System.out.printf(" # High Fashion --> %d%n", highFishion);
        }
        if (pearSour >= 1) {
            System.out.printf(" # Pear Sour --> %d%n", pearSour);
        }
        if (harvest >= 1) {
            System.out.printf(" # The Harvest --> %d", harvest);
        }

    }
}
