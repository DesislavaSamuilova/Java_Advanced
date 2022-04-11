import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OS_Planning_1exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputNumbersFirst = scanner.nextLine().split(", ");
        ArrayDeque<Integer> task = new ArrayDeque<>();
        for (String numberFir : inputNumbersFirst) {
            task.push(Integer.valueOf(numberFir.toString()));
        }
        String[] inputNumbersSecond = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> thread = new ArrayDeque<>();
        for (String numberSec : inputNumbersSecond) {
            thread.add(Integer.valueOf(numberSec.toString()));
        }
        int valueOfTask = Integer.parseInt(scanner.nextLine());
        while (!task.isEmpty() && !thread.isEmpty()) {
            int taskNum = task.getFirst();
            int threadNum = thread.getFirst();
            if (taskNum == valueOfTask) {
                System.out.printf("Thread with value %d killed task %d", threadNum, valueOfTask);
                break;
            }
            if (threadNum >= taskNum) {
                task.poll();
                thread.pop();
            } else {
                thread.pop();
            }
        }

         System.out.println();
         System.out.println(thread.toString().replaceAll("[\\[\\],]", ""));
    }
}