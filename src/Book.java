public class Book {
    private int id;
    private String title;
    private String author;
    private boolean available;
    private int issuedTo; // member id, 0 means nobody

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
        this.issuedTo = 0;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public int getIssuedTo() { return issuedTo; }
    public void setIssuedTo(int issuedTo) { this.issuedTo = issuedTo; }

    @Override
    public String toString() {
        String status = available ? "Available" : "Issued to member " + issuedTo;
        return id + " | " + title + " | " + author + " | " + status;
    }
}