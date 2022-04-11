import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class A_MinnerTask_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();
        while (true) {
            String resource = scanner.nextLine();
            if (resource.equals("stop")) {
                break;
            }
            int quantity = Integer.parseInt(scanner.nextLine());

            if (resources.containsKey(resource)) {
                int currentCount = resources.get(resource);
                resources.put(resource, currentCount + quantity);
            } else {
                resources.put(resource, quantity);
            }

        }

        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }


    }
}
