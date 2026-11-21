public class App {
    public static void main(String[] args) {
        Book b1 = new Book(1, "Clean Code", "Robert Martin");
        Book b2 = new Book(2, "Effective Java", "Joshua Bloch");
        System.out.println(b1);
        System.out.println(b2);
    }
}