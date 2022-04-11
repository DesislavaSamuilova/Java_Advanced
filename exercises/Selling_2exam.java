import java.math.BigInteger;
import java.util.Scanner;

public class Selling_2exam {
    public static int startRow = 0;
    public static int startCol = 0;
    public static int money = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] bakery = new char[size][size];

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            bakery[row] = line.toCharArray();
            if (line.contains("S")) {
                startRow = row;
                startCol = line.indexOf("S");
            }
        }
        boolean isCollect = true;
        while (money < 50 && isCollect) {
            String command = scanner.nextLine();
            switch (command) {
                case "up": //row -1
                    isCollect = move(startRow - 1, startCol, bakery);
                    break;
                case "down": //row +1
                    isCollect = move(startRow + 1, startCol, bakery);
                    break;
                case "left"://col -1
                    isCollect = move(startRow, startCol - 1, bakery);
                    break;
                case "right"://col +1
                    isCollect = move(startRow, startCol + 1, bakery);
                    break;
            }

        }
        if (!isCollect) {
            System.out.println("Bad news, you are out of the bakery.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d", money);
        System.out.println();
        printBakery(bakery);
    }

    private static void printBakery(char[][] bakery) {
        for (int row = 0; row < bakery.length; row++) {
            for (int c = 0; c < bakery[row].length; c++) {
                System.out.print(bakery[row][c]);
            }
            System.out.println();
        }
    }

    private static boolean move(int newRow, int newCol, char[][] bakery) {
        bakery[startRow][startCol] = '-';
        if (isBakerOutOfBounds(newRow, newCol, bakery)) {
            return false;
        }
        char symbol = bakery[newRow][newCol];
        if (Character.isDigit(symbol)) {
            money += symbol - '0';

        } else if (symbol == 'O') {
            bakery[newRow][newCol] = '-';
            int[] secondPillarLocation = findSecondPillarInShop(bakery);
            newRow = secondPillarLocation[0];
            newCol = secondPillarLocation[1];
        }

        bakery[newRow][newCol] = 'S';
        startRow = newRow;
        startCol = newCol;
        return true;

    }

    private static int[] findSecondPillarInShop(char[][] bakery) {
        int[] indexes = null;
        for (int r = 0; r < bakery.length; r++) {
            for (int c = 0; c < bakery[r].length; c++) {
                if (bakery[r][c] == 'O') {
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

    private static boolean isBakerOutOfBounds(int row, int col, char[][] bakery) {
        return row >= bakery.length || row < 0
                || col >= bakery[row].length || col < 0;
    }
}