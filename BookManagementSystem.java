import java.util.Scanner;

// Base class: Publisher
class Publisher {
    String publisherName;

    Publisher(String publisherName) {
        this.publisherName = publisherName;
    }

    void displayPublisher() {
        System.out.println("Publisher: " + publisherName);
    }
}

// Derived class: Book
class Book extends Publisher {
    String bookTitle;
    String author;
    double price;

    Book(String publisherName, String bookTitle, String author, double price) {
        super(publisherName);
        this.bookTitle = bookTitle;
        this.author = author;
        this.price = price;
    }

    void displayBookDetails() {
        displayPublisher();
        System.out.println("Book Title: " + bookTitle);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }
}

// Subclass: Literature
class Literature extends Book {
    Literature(String publisherName, String bookTitle, String author, double price) {
        super(publisherName, bookTitle, author, price);
    }

    void display() {
        System.out.println("\n**Literature Book Details**");
        displayBookDetails();
    }
}

// Subclass: Fiction
class Fiction extends Book {
    Fiction(String publisherName, String bookTitle, String author, double price) {
        super(publisherName, bookTitle, author, price);
    }

    void display() {
        System.out.println("\n**Fiction Book Details**");
        displayBookDetails();
    }
}

// Main class
public class BookManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Literature Book
        System.out.println("Enter Literature Book Details:");
        System.out.print("Publisher: ");
        String litPublisher = scanner.nextLine();
        System.out.print("Title: ");
        String litTitle = scanner.nextLine();
        System.out.print("Author: ");
        String litAuthor = scanner.nextLine();
        System.out.print("Price: ");
        double litPrice = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        Literature literature = new Literature(litPublisher, litTitle, litAuthor, litPrice);

        // Input for Fiction Book
        System.out.println("\nEnter Fiction Book Details:");
        System.out.print("Publisher: ");
        String ficPublisher = scanner.nextLine();
        System.out.print("Title: ");
        String ficTitle = scanner.nextLine();
        System.out.print("Author: ");
        String ficAuthor = scanner.nextLine();
        System.out.print("Price: ");
        double ficPrice = scanner.nextDouble();
        Fiction fiction = new Fiction(ficPublisher, ficTitle, ficAuthor, ficPrice);

        // Display book details
        literature.display();
        fiction.display();
    }
}
