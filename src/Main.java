import java.util.*;

public class Main {
    static MyHashMap map = new MyHashMap();
    static Scanner sc = new Scanner(System.in);

    // Generate short code
    public static String generateCode() {
        String chars = "abcdefghijklmnopqrstuvwxyz123456789";
        StringBuilder code = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < 6; i++) {
            code.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return code.toString();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Shorten URL");
            System.out.println("2. Open URL");
            System.out.println("3. View Analytics");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter long URL: ");
                    String longURL = sc.nextLine();
                    String code = generateCode();
                    map.put(code, longURL);
                    System.out.println("Short URL: short.ly/" + code);
                    break;

                case 2:
                    System.out.print("Enter short code: ");
                    String openCode = sc.nextLine();
                    String result = map.get(openCode);

                    if (result != null) {
                        System.out.println("Redirecting to: " + result);
                    } else {
                        System.out.println("URL not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter short code: ");
                    String analyticsCode = sc.nextLine();
                    int count = map.getClickCount(analyticsCode);

                    if (count != -1) {
                        System.out.println("Clicked " + count + " times");
                    } else {
                        System.out.println("URL not found!");
                    }
                    break;

                case 4:
                    System.exit(0);
            }
        }
    }
}