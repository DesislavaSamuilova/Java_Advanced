import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithaStack_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputNumbers = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String number : inputNumbers) {
            stack.push(number);
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
