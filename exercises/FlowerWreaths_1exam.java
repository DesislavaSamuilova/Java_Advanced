
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlowerWreaths_1exam {
    public static int wreath = 0;
    public static int storedFlowers = 0;
    public static int sumAllWreaths = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputNumbersFirst = scanner.nextLine().split(", ");
        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        for (String numberFir : inputNumbersFirst) {
            lilies.push(Integer.valueOf(numberFir.toString()));
        }

        String[] inputNumbersSecond = scanner.nextLine().split(", ");
        ArrayDeque<Integer> roses = new ArrayDeque<>();
        for (String numberSec : inputNumbersSecond) {
            roses.add(Integer.valueOf(numberSec.toString()));
        }

        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int liliesNum = lilies.getFirst();
            int rosesNum = roses.getFirst();
            int sumFlowers = liliesNum + rosesNum;
            if (sumFlowers == 15) {
                wreath++;
                lilies.remove();
                roses.pop();
            } else if (sumFlowers > 15) {
                lilies.pop();
                lilies.push(liliesNum - 2);
            } else {
                storedFlowers += sumFlowers;
                lilies.remove();
                roses.pop();
            }
        }
        if (storedFlowers > 0) {
            int leftWreaths = storedFlowers / 15;
            sumAllWreaths = wreath + leftWreaths;
        }
        if(wreath >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreath);
        } else{
            int needWreaths = 5 -sumAllWreaths;
            System.out.printf("You didn't make it, you need %d wreaths more!", needWreaths);
        }
    }
}