import java.util.Scanner;

public class CookingJourney_2exam {
    public static int startRow = 0, startCol = 0;
    public static int money = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] pastryShop = new char[size][size];

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            pastryShop[row] = line.toCharArray();
            if (line.contains("S")) {
                startRow = row;
                startCol = line.indexOf("S");
            }
        }

        boolean isWithinShop = true;

        while (money < 50 && isWithinShop) {
            String command = scanner.nextLine();
            switch (command) {
                case "up": //row -1
                    isWithinShop = move(startRow - 1, startCol, pastryShop);
                    break;
                case "down": //row +1
                    isWithinShop = move(startRow + 1, startCol, pastryShop);
                    break;
                case "left"://col -1
                    isWithinShop = move(startRow, startCol - 1, pastryShop);
                    break;
                case "right"://col +1
                    isWithinShop = move(startRow, startCol + 1, pastryShop);
                    break;
            }

        }

        String output = "";
        if (!isWithinShop){
            output = "Bad news! You are out of the pastry shop.";
        } else {
            output = "Good news! You succeeded in collecting enough money!";
        }
        System.out.println(output);
        System.out.println("Money: " + money);
        printPastryShop(pastryShop);


    }

    private static boolean move(int newRow, int newCol, char[][] pastryShop) {
        pastryShop[startRow][startCol] = '-';
        if (isBakerOutOfBounds(newRow, newCol, pastryShop)) {
            return false;
        }
        char symbol = pastryShop[newRow][newCol];
        if (Character.isDigit(symbol)) {
            money += symbol - '0';

        }else if (symbol == 'P') {
            pastryShop[newRow][newCol] = '-';
            int [] secondPillarLocation = findSecondPillarInShop(pastryShop);
            newRow = secondPillarLocation[0];
            newCol = secondPillarLocation[1];
        }

        pastryShop[newRow][newCol] = 'S';
        startRow = newRow;
        startCol = newCol;
        return true;

    }

    private static int[] findSecondPillarInShop(char[][] pastryShop) {
        int[] indexes = null;
        for (int r = 0; r < pastryShop.length; r++) {
            for (int c = 0; c < pastryShop[r].length; c++) {
                if (pastryShop[r][c] == 'P'){
                    indexes = new int [] {r, c};
                    break;
                }
            }
            if (indexes != null){
                break;
            }
        }
        return indexes;
    }

    private static void printPastryShop(char[][] pastryShop) {
        for (int row = 0; row < pastryShop.length; row++) {
            for (int c = 0; c < pastryShop[row].length; c++) {
                System.out.print(pastryShop[row][c]);
            }
            System.out.println();
        }
    }

    private static boolean isBakerOutOfBounds(int row, int col, char[][] matrix) {
        return row >= matrix.length || row < 0
                || col >= matrix[row].length || col < 0;
    }
}