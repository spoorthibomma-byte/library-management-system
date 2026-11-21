import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int nextId = 1;

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add book");
            System.out.println("2. View all books");
            System.out.println("3. Search book by title");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clears the leftover newline

            if (choice == 1) {
                System.out.print("Title: ");
                String title = sc.nextLine();
                System.out.print("Author: ");
                String author = sc.nextLine();
                books.add(new Book(nextId++, title, author));
                System.out.println("Book added.");
            } else if (choice == 2) {
                if (books.isEmpty()) {
                    System.out.println("No books yet.");
                } else {
                    for (Book b : books) {
                        System.out.println(b);
                    }
                }
            } else if (choice == 3) {
                System.out.print("Enter word to search: ");
                String word = sc.nextLine();
                boolean found = false;

                for (Book b : books) {
                    if (b.getTitle().toLowerCase().contains(word.toLowerCase())) {
                        System.out.println(b);
                        found = true;
                    }
                }

                if (!found) {
                System.out.println("No match found.");
                }
            } else if (choice == 4) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}