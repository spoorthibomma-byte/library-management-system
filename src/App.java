import java.util.ArrayList;
import java.util.Scanner;

public class App {

    // Looks for a book with this id. Returns null if not found.
    static Book findBook(ArrayList<Book> books, int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    // Same idea, for members.
    static Member findMember(ArrayList<Member> members, int id) {
        for (Member m : members) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Member> members = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int nextId = 1;
        int nextMemberId = 1;

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add book");
            System.out.println("2. View all books");
            System.out.println("3. Search book by title");
            System.out.println("4. Register member");
            System.out.println("5. View all members");
            System.out.println("6. Issue book");
            System.out.println("7. Return book");
            System.out.println("8. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

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
                System.out.print("Name: ");
                String name = sc.nextLine();
                members.add(new Member(nextMemberId++, name));
                System.out.println("Member registered.");
            } else if (choice == 5) {
                if (members.isEmpty()) {
                    System.out.println("No members yet.");
                } else {
                    for (Member m : members) {
                        System.out.println(m);
                    }
                }
            } else if (choice == 6) {
                System.out.print("Book id: ");
                int bookId = sc.nextInt();
                System.out.print("Member id: ");
                int memberId = sc.nextInt();
                sc.nextLine();

                Book book = findBook(books, bookId);
                Member member = findMember(members, memberId);

                if (book == null) {
                    System.out.println("Book not found.");
                } else if (member == null) {
                    System.out.println("Member not found.");
                } else if (!book.isAvailable()) {
                    System.out.println("Book is already issued.");
                } else {
                    book.setAvailable(false);
                    book.setIssuedTo(memberId);
                    System.out.println(book.getTitle() + " issued to " + member.getName());
                }
            } else if (choice == 7) {
                System.out.print("Book id: ");
                int bookId = sc.nextInt();
                sc.nextLine();

                Book book = findBook(books, bookId);

                if (book == null) {
                    System.out.println("Book not found.");
                } else if (book.isAvailable()) {
                    System.out.println("This book was not issued.");
                } else {
                    book.setAvailable(true);
                    book.setIssuedTo(0);
                    System.out.println("Book returned.");
                }
            } else if (choice == 8) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}