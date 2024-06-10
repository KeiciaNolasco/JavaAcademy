package academiajava.exercicio01;

import academiajava.exercicio01.entities.Book;
import academiajava.exercicio01.entities.Librarian;
import academiajava.exercicio01.entities.Library;
import academiajava.exercicio01.services.LibraryService;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book(1, "Amor", "Maria", 2001);
        Book book2 = new Book(2, "Coragem", "João", 2002);
        Book book3 = new Book(3, "Alegria", "Carlos", 2003);

        Library library = new Library(1, "Academia Java");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        Librarian librarian1 = new Librarian(1, "Lucas", "lucas@gmail.com", "123");
        Librarian librarian2 = new Librarian(2, "Keicia", "keicia@gmail.com", "123");

        List<Librarian> librarians = new ArrayList<>();
        librarians.add(librarian1);
        librarians.add(librarian2);

        LibraryService libraryService = new LibraryService();

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter your email or name: ");
        String input = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        boolean authenticated = false;

        for (Librarian librarian : librarians) {
            if (libraryService.authenticate(librarian, input, password)) {
                authenticated = true;
                System.out.println("\nAuthentication successful!");
                System.out.println("\nWelcome to the " + library.getName());
                System.out.print("1-Search for a book;\n2-List all books.\nEnter the number of the action you want to perform: ");
                int action = scanner.nextInt();
                scanner.nextLine();

                if (action == 1) {
                    System.out.print("\nEnter the value to search for (title, author, year): ");
                    String obj = scanner.nextLine();
                    libraryService.listBooks(library, obj);
                }
                else if (action == 2) {
                    libraryService.listBooks(library);
                }
                else {
                    System.out.println("Invalid action.");
                }
                break;
            }
        }

        if (!authenticated) {
            System.out.println("Authentication failed.");
        }

        scanner.close();
    }

}