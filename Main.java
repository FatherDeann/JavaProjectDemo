import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Title: \"" + title + "\", Author: " + author + ", Price: $" + price;
    }

    public String getTitle() {
        return title;
    }
}

public class Main {
    private static List<Book> inventory = new ArrayList<>();

    public static void main(String[] args) {
        addBook("The Great Gatsby", "F. Scott Fitzgerald", 10.99);
        addBook("1984", "George Orwell", 9.99);
        addBook("To Kill a Mockingbird", "Harper Lee", 12.99);

        System.out.println("Current Inventory:");
        displayInventory();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter a book title to search: ");
        String title = scanner.nextLine();
        searchBookByTitle(title);
    }

    private static void addBook(String title, String author, double price) {
        Book book = new Book(title, author, price);
        inventory.add(book);
    }

    private static void displayInventory() {
        for (Book book : inventory) {
            System.out.println(book);
        }
    }

    private static void searchBookByTitle(String title) {
        for (Book book : inventory) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book);
                return;
            }
        }
        System.out.println("Book not found.");
    }
}