import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        fillMatrix(scanner, matrix);

        int sumPrimary = getSumPrimaryDiagonal(matrix);
        int sumSecondary = getSumSecondaryDiagonal(matrix);
        System.out.println(Math.abs(sumPrimary - sumSecondary));
    }
        private static int getSumSecondaryDiagonal(int[][] matrix){
            int sum = 0;
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix.length; col++) {
                    if (col == matrix.length - row - 1) {
                        sum += matrix[row][col];
                    }
                }
            }
            return sum;
        }

        private static int getSumPrimaryDiagonal(int[][] matrix){
            int sum = 0;
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix.length; col++) {
                    if (row == col) {
                        sum += matrix[row][col];
                    }
                }
            }
            return sum;
        }


        public static void fillMatrix (Scanner scanner,int[][] matrix){
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix.length; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
        }
        public static void printMatrix ( int[][] matrix, int rows, int cols){
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col] + " ");
                }
                System.out.println();
            }
        }
    }
