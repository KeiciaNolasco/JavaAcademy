package academiajava.exercicio01.services;

import academiajava.exercicio01.entities.Library;
import academiajava.exercicio01.entities.Librarian;

public class LibraryService {

    public boolean authenticate(Librarian librarian, String input, String password) {
        return (input.equals(librarian.getEmail()) || input.equalsIgnoreCase(librarian.getName())) && password.equals(librarian.getPassword());
    }

    public void listBooks(Library library) {
        library.listBooks();
    }

    public void listBooks(Library library, String obj) {
        library.listBooks(obj);
    }

}