import java.util.Scanner;

public class FillTheMatrix_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();//"3, A".split -> ["3", "A"]
        int n = Integer.parseInt(input.split(", ")[0]); //размер на кв. матрица -> брой редове  = брой колоните = n
        String pattern = input.split(", ")[1]; //A или B

        int [][] matrix = new int[n][n];
        if (pattern.equals("A")) {
            //попълваме матрицата по начин А -> по колони
            fillMatrixPatternA(matrix);
        } else if (pattern.equals("B")) {
            //попълваме матрицата по начин B
            fillMatrixPatternB(matrix);
        }
        printMatrix(matrix, n, n);
    }

    private static void fillMatrixPatternB(int [][] matrix) {
        //четни колони -> 0 до последния
        //нечетни колони -> последния до 0
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length ; row++) {
                    matrix[row][col] = startNumber++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = startNumber++;
                }
            }
        }
    }

    private static void fillMatrixPatternA(int [][] matrix) {
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = startNumber++;
                //startNumber++;
            }
        }
    }

    public static void printMatrix (int [][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}