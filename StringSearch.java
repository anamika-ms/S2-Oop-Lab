import java.util.Scanner;

public class StringSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String[] strings = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
        }

        System.out.print("Enter string to search: ");
        String searchStr = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (strings[i].equals(searchStr)) {
                System.out.println("String found at index: " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("String not found.");
        }
    }
}

