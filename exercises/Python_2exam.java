import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Python_2exam {
    private static int food;
    public static int startRow = 0;
    public static int startCol = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> commands = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toCollection(ArrayDeque::new));

        char[][] matrix = new char[size][size];

        int resultFood = 1;

        for (int i = 0; i < matrix.length; i++) {
            String input = scanner.nextLine().replaceAll("\\s+", "");
            matrix[i] = input.toCharArray();

            if (input.contains("s")) {
                startRow = i;
                startCol = input.indexOf("s");
            }
            for (int j = 0; j < input.length(); j++) {
                char symbol = input.charAt(j);
                if (symbol == 'f') {
                    food++;
                    resultFood++;
                }
            }
        }
        boolean stepOnEnemy = false;
        while (!commands.isEmpty() && food > 0) {
            String command = commands.poll();

            if (command.equals("up")) {
                stepOnEnemy = move(matrix, startRow - 1, startCol);

            } else if (command.equals("down")) {
                stepOnEnemy = move(matrix, startRow + 1, startCol);

            } else if (command.equals("left")) {
                stepOnEnemy = move(matrix, startRow, startCol - 1);

            } else if (command.equals("right")) {
                stepOnEnemy = move(matrix, startRow, startCol + 1);

            }

            if (stepOnEnemy) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
        }

        if (food == 0) {
            System.out.printf("You win! Final python length is %d", resultFood);
            return;
        }
        if (commands.isEmpty() && food > 0) {
            System.out.printf("You lose! There is still %d food to be eaten.", food);
        }
    }


    private static boolean move(char[][] matrix, int newRow, int newCol) {
        newRow = checkTheIndex(matrix, newRow);
        newCol = checkTheIndex(matrix, newCol);

        if (matrix[newRow][newCol] == 'f') {
            food--;

        } else if (matrix[newRow][newCol] == 'e') {
            return true;
        }

        startRow = newRow;
        startCol = newCol;

        return false;

    }


    private static int checkTheIndex(char[][] matrix, int index) {
        if (index > matrix.length - 1) {
            index = 0;

        } else if (index < 0) {
            index = matrix.length - 1;
        }
        return index;

    }


    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

}
