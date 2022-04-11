import java.util.*;

public class SantasPresentFactory_1exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> craftingToys = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(craftingToys::push);
        ArrayDeque<Integer> magicLevel = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(magicLevel::offer);
        TreeMap<String, Integer> toys = new TreeMap<>();


        while (!craftingToys.isEmpty() && !magicLevel.isEmpty()) {
            int firstSum = craftingToys.peek();
            int secondSum = magicLevel.peek();
            int sum = firstSum * secondSum;

            String gift;
            if (sum < 0) {
                sum = firstSum + secondSum;
                magicLevel.pop();
                craftingToys.poll();
                craftingToys.push(sum);
            } else if (firstSum == 0 || sum == 0) {
                if (firstSum == 0) {
                    craftingToys.pop();
                }
                if (secondSum == 0) {
                    magicLevel.poll();
                }
            } else if (sum == 150 || sum == 250 || sum == 300
                    || sum == 400) {
                if (sum == 150) {
                    gift = "Doll";
                    craftingToys.poll();
                    magicLevel.pop();
                    toys.putIfAbsent(gift, 0);
                    toys.put(gift, toys.get(gift) + 1);
                } else if (sum == 250) {
                    gift = "Wooden train";
                    craftingToys.poll();
                    magicLevel.pop();
                    toys.putIfAbsent(gift, 0);
                    toys.put(gift, toys.get(gift) + 1);
                } else if (sum == 300) {
                    gift = "Teddy bear";
                    craftingToys.poll();
                    magicLevel.pop();
                    toys.putIfAbsent(gift, 0);
                    toys.put(gift, toys.get(gift) + 1);
                } else {
                    gift = "Bicycle";
                    craftingToys.poll();
                    magicLevel.pop();
                    toys.putIfAbsent(gift, 0);
                    toys.put(gift, toys.get(gift) + 1);
                }
            } else {
                magicLevel.poll();
                firstSum += 15;
                craftingToys.poll();
                craftingToys.push(firstSum);
            }

        }
        if (toys.containsKey("Doll") && toys.containsKey("Wooden train")) {
            System.out.println("The presents are crafted! Merry Christmas!");
        }
        if (toys.containsKey("Bicycle") && toys.containsKey("Teddy bear")) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (craftingToys.size() > 0) {
            System.out.print("Materials left: ");

            for (int i = 0; i < craftingToys.size(); i++) {
                if (i == craftingToys.size() - 1) {
                    System.out.println(craftingToys.pop());
                } else {
                    System.out.print(craftingToys.pop() + ", ");
                    i--;
                }
            }
        }

        if (magicLevel.size() > 0) {
            System.out.print("Magic left: ");
            for (int i = 0; i < magicLevel.size(); i++) {
                if (i == magicLevel.size() - 1) {
                    System.out.println(magicLevel.poll());
                } else {
                    System.out.print(magicLevel.poll() + ", ");
                    i--;
                }
            }
        }

        for (Map.Entry<String, Integer> entry : toys.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

