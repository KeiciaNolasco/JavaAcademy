package academiajava.exercicio01.entities;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private Integer id;
    private String name;

    private List<Book> books = new ArrayList<>();

    public Library() {
    }

    public Library(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() +
                    ", Author: " + book.getAuthor() + ", Year: " + book.getYear());
        }
    }

    public void listBooks(String obj) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(obj) ||
                    book.getAuthor().equalsIgnoreCase(obj) ||
                    book.getYear().toString().equals(obj) ||
                    book.getId().toString().equals(obj)) {
                System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() +
                        ", Author: " + book.getAuthor() + ", Year: " + book.getYear());
            }
        }
    }

}
