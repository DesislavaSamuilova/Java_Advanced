import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PastryShop_1exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(liquids::offer);
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(ingredients::push);

        int biscuit = 0;
        int cake = 0;
        int pie = 0;
        int pastry = 0;

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int firstSum = liquids.peek();
            int secondSum = ingredients.peek();
            int sum = firstSum + secondSum;
            if (sum == 25) {
                biscuit++;
                liquids.poll();
                ingredients.pop();
            } else if (sum == 50) {
                cake++;
                liquids.poll();
                ingredients.pop();
            } else if (sum == 75) {
                pastry++;
                liquids.poll();
                ingredients.pop();
            } else if (sum == 100) {
                pie++;
                liquids.poll();
                ingredients.pop();
            } else {
                liquids.poll();
                ingredients.pop();
                ingredients.push(secondSum + 3);
            }
        }
        if (biscuit >= 1 && cake >= 1 && pastry >= 1 && pie >= 1) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.println("Liquids left: " + liquids.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.println("Ingredients left: " + ingredients.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        }
        System.out.println("Biscuit: " + biscuit);
        System.out.println("Cake: " + cake);
        System.out.println("Pie: " + pie);
        System.out.println("Pastry: " + pastry);
    }
}

