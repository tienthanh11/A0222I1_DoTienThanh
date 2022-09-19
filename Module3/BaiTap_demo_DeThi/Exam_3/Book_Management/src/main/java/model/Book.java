package model;

public class Book {
    private int bookId;
    private String name;
    private String author;
    private String description;
    private int quantity;

    public Book() {
    }

    public Book(int bookId, String name, String author, String description, int quantity) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.description = description;
        this.quantity = quantity;
    }

    public Book(String name, String author, String description, int quantity) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.quantity = quantity;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
