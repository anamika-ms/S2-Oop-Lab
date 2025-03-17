import java.io.*;
import java.util.Scanner;

public class FileOperations {
    public static void writeFile(String filename, String data) throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write(data);
        writer.close();
        System.out.println("Data written to file successfully.");
    }

    public static void readFile(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found.");
        }
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        System.out.println("File contents:");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    public static void appendToFile(String filename, String data) throws IOException {
        FileWriter writer = new FileWriter(filename, true);
        writer.write(data);
        writer.close();
        System.out.println("Data appended to file successfully.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:\n1. Write\n2. Read\n3. Append");
        int choice = scanner.nextInt();
        scanner.nextLine();  

        System.out.print("Enter filename: ");
        String filename = scanner.nextLine();

        try {
            switch (choice) {
                case 1:
                    System.out.print("Enter data to write: ");
                    String writeData = scanner.nextLine();
                    writeFile(filename, writeData);
                    break;
                case 2:
                    readFile(filename);
                    break;
                case 3:
                    System.out.print("Enter data to append: ");
                    String appendData = scanner.nextLine();
                    appendToFile(filename, appendData);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}
