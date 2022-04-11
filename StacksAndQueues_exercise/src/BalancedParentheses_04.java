import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Character> openBrackets = new ArrayDeque<>();
        boolean isBalanced = false;
        for (int index = 0; index < input.length(); index++) {
            char currentBracket = input.charAt(index);
            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                openBrackets.push(currentBracket);
            } else if (currentBracket == ')' || currentBracket == '}' || currentBracket == ']') {
                if (openBrackets.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char lastOpenBracket = openBrackets.pop();
                if (lastOpenBracket == '(' && currentBracket == ')') {
                    isBalanced = true;
                } else if (lastOpenBracket == '{' && currentBracket == '}') {
                    isBalanced = true;
                } else if (lastOpenBracket == '[' && currentBracket == ']') {
                    isBalanced = true;
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}