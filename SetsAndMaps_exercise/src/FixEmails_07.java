import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> emailsData = new LinkedHashMap<>();
        String name = scanner.nextLine();
        while (!name.equals("stop")) {

            String email = scanner.nextLine();
            if(!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                emailsData.put(name, email);
            }
            name = scanner.nextLine();
        }

        emailsData.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}

