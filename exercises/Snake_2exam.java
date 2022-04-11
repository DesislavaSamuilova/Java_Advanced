import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Snake_2exam {
    public static int startRow = 0;
    public static int startCol = 0;
    public static int food = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];


        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("S")) {
                startRow = row;
                startCol = line.indexOf("S");
            }
        }
        boolean isReady = true;
        while (isReady) {
            if (food >= 10) {
               break;
            }
            String command = scanner.nextLine();

            switch (command) {
                case "up": //row -1
                    isReady = move(startRow - 1, startCol, matrix);
                    break;
                case "down": //row +1
                    isReady = move(startRow + 1, startCol, matrix);
                    break;
                case "left"://col -1
                    isReady = move(startRow, startCol - 1, matrix);
                    break;
                case "right"://col +1
                    isReady = move(startRow, startCol + 1, matrix);
                    break;
            }

        }
        if (!isReady) {
            System.out.println("Game over!");
        }

        if (food >= 10) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.printf("Food eaten: %d", food);
        System.out.println();
        printMatrix(matrix);
    }


    private static boolean move(int newRow, int newCol, char[][] matrix) {
        matrix[startRow][startCol] = '.';
        if (isBakerOutOfBounds(newRow, newCol, matrix)) {
            return false;
        }
        char symbol = matrix[newRow][newCol];
        if (symbol == '*') {
            food++;

        } else if (symbol == 'B') {
            matrix[newRow][newCol] = '.';
            int[] secondPillarLocation = findSecondLairInShop(matrix);
            newRow = secondPillarLocation[0];
            newCol = secondPillarLocation[1];
        }

        matrix[newRow][newCol] = 'S';
        startRow = newRow;
        startCol = newCol;
        return true;

    }

    private static int[] findSecondLairInShop(char[][] matrix) {
        int[] indexes = null;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'B') {
                    indexes = new int[]{r, c};
                    break;
                }
            }
            if (indexes != null) {
                break;
            }
        }
        return indexes;
    }

    private static boolean isBakerOutOfBounds(int row, int col, char[][] matrix) {
        return row >= matrix.length || row < 0
                || col >= matrix[row].length || col < 0;
    }


    public static void printMatrix(char[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix.length; cols++) {
                System.out.print(matrix[rows][cols]);
            }
            System.out.println();
        }
    }
}



