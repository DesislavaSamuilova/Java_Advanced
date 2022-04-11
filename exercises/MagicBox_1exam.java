import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MagicBox_1exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputNumbersFirst = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> firstMagicBox = new ArrayDeque<>();
        for (String numberFir : inputNumbersFirst) {
            firstMagicBox.add(Integer.valueOf(numberFir.toString()));
        }
        String[] inputNumbersSecond = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> secondMagicBox = new ArrayDeque<>();
        for (String numberSec : inputNumbersSecond) {
            secondMagicBox.push(Integer.valueOf(numberSec.toString()));
        }
        int value = 0;
        List<Integer> claimedItems = new ArrayList<>();
        while (!firstMagicBox.isEmpty() && !secondMagicBox.isEmpty()) {
            int firstSum = firstMagicBox.getFirst();
            int secondSum = secondMagicBox.getFirst();
            int sum = firstSum + secondSum;
            if (sum % 2 == 0) {
                claimedItems.add(sum);
                value += sum;
                firstMagicBox.remove();
                secondMagicBox.poll();
            } else {
                secondMagicBox.poll();
                firstMagicBox.add(secondSum);
            }
        }
        if (firstMagicBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }
        if(value >= 90){
            System.out.printf("Wow, your prey was epic! Value: %d", value);
        }else {
            System.out.printf("Poor prey... Value: %d", value);
        }
    }
}
