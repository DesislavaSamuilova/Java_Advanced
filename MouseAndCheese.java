import hotel.Person;

import java.util.Scanner;

public class MouseAndCheese {
    public static int startRow = 0, startCol = 0;
    public static int cheese = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < size; col++) {
                matrix[row][col] = line.charAt(col);
                if (matrix[row][col] == 'M') {
                    startRow = row;
                    startCol = col;
                    matrix[row][col] = '-';
                }
            }
        }
        boolean isOut = true;
        String command = scanner.nextLine();
        while (!command.equals("end") && isOut) {
            if ("up".equals(command)) {
                isOut = checkPosition(matrix, -1, 0);;
            } else if ("down".equals(command)) {
                isOut = checkPosition(matrix, +1, 0);;
            } else if ("left".equals(command)) {
                isOut = checkPosition(matrix, 0, -1);;
            } else if ("right".equals(command)) {
                isOut = checkPosition(matrix, 0, +1);;
            }
            if (!isOut) {
                break;
            }
            command = scanner.nextLine();
        }

        if (!isOut) {
            System.out.println("Where is the mouse?");
        } else {
            matrix[startRow][startCol] = 'M';
        }
        if (cheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!", cheese);
        } else {
            int neededCheese = 5 - cheese;
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.", neededCheese);
        }

        System.out.println();
        System.out.println(getPrint(matrix));

    }

    private static String getPrint(char[][] matrix) {
        StringBuilder out = new StringBuilder();
        for (char[] row : matrix) {
            for (char element : row) {
                out.append(element);
            }
            out.append(System.lineSeparator());
        }
        return out.toString();

    }


    private static boolean checkPosition(char[][] matrix, int row, int col) {
        if (isOutOfBounds(matrix, row + startRow, col + startCol)) {
            startRow = startRow + row;
            startCol = startCol + col;
            char symbol = matrix[startRow][startCol];
            if (symbol == 'c') {
                cheese++;
                matrix[startRow][startCol] = '-';

            } else if (symbol == 'B') {
                matrix[startRow][startCol] = '-';
                checkPosition(matrix, row, col);
            } else {
                matrix[startRow][startCol] = '-';
            }
            return true;

        }
        return false;
    }

    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        return r >= matrix.length || r < 0
                || c >= matrix[r].length || c < 0;

    }
}
