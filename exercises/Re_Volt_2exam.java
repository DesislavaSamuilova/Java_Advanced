import java.util.Scanner;

public class Re_Volt_2exam {
    public static int startRow = 0;
    public static int startCol = 0;
    private static int[] position;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        int countOfCommands = Integer.parseInt(scanner.nextLine());


        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("t")) {
                startRow = row;
                startCol = line.indexOf("t");
            }
        }
        boolean isFinish = false;
        while (countOfCommands-- > 0 && !isFinish) {
            String command = scanner.nextLine();
            switch (command) {
                case "up": //row -1
                    isFinish = move(position, matrix, -1, 0);
                    break;
                case "down": //row +1
                    isFinish = move(position, matrix, +1, 0);
                    break;
                case "left"://col -1
                    isFinish = move(position, matrix, 0, -1);
                    break;
                case "right"://col +1
                    isFinish = move(position, matrix, 0, +1);
                    break;
            }
        }
        if (isFinish) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char symbol : arr) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }


    private static boolean move(int[] position, char[][] matrix,
                                int rowNew, int colNew) {
        int row = position[0];
        int col = position[1];
        int newRow = checkIsOutside(row + rowNew, matrix.length);
        int newCol = checkIsOutside(col + colNew, matrix.length);

        boolean hasWon = false;

        if (matrix[newRow][newCol] == 'F') {
            hasWon = true;
        } else if (matrix[newRow][newCol] == 'B') {
            hasWon = move(position, matrix, rowNew, colNew);
        } else if (matrix[newRow][newCol] == 'T') {
            newRow = row;
            newCol = col;
        }

        matrix[row][col] = '-';
        matrix[newRow][newCol] = 'f';
        position[0] = newRow;
        position[1] = newCol;
        return hasWon;
    }

    private static int checkIsOutside(int value, int size) {
        if (value < 0) {
            value = size - 1;
        } else if (value >= size) {
            value = 0;
        }
        return value;
    }
}