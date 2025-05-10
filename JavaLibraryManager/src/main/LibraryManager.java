import java.util.*;

public class LibraryManager {
    private List<Book> books;
    private List<User> users;

    private final String BOOK_FILE = "data/books.txt";
    private final String USER_FILE = "data/users.txt";

    public LibraryManager() {
        books = FileHandler.loadBooks(BOOK_FILE);
        users = FileHandler.loadUsers(USER_FILE);
    }

    public void addBook(Book book) {
        books.add(book);
        FileHandler.saveBooks(BOOK_FILE, books);
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        books.forEach(b -> System.out.println(b.getId() + " | " + b.getTitle() + " | " +
                b.getAuthor() + " | " + (b.isIssued() ? "Issued" : "Available")));
    }

    public void issueBook(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId) && !book.isIssued()) {
                book.issue();
                FileHandler.saveBooks(BOOK_FILE, books);
                System.out.println("Book issued.");
                return;
            }
        }
        System.out.println("Book not found or already issued.");
    }

    public void returnBook(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId) && book.isIssued()) {
                book.returnBook();
                FileHandler.saveBooks(BOOK_FILE, books);
                System.out.println("Book returned.");
                return;
            }
        }
        System.out.println("Book not issued or not found.");
    }

    public void registerUser(User user) {
        users.add(user);
        FileHandler.saveUsers(USER_FILE, users);
    }

    public void viewUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }
        users.forEach(u -> System.out.println(u.getId() + " | " + u.getName()));
    }
}
