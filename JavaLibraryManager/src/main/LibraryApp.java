import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\n=== Java Library Manager ===");
            System.out.println("1. View Books");
            System.out.println("2. Add Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Register User");
            System.out.println("6. View Users");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    manager.viewBooks();
                    break;
                case "2":
                    System.out.print("Enter Book ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    manager.addBook(new Book(id, title, author));
                    break;
                case "3":
                    System.out.print("Enter Book ID to issue: ");
                    manager.issueBook(scanner.nextLine());
                    break;
                case "4":
                    System.out.print("Enter Book ID to return: ");
                    manager.returnBook(scanner.nextLine());
                    break;
                case "5":
                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter User Name: ");
                    String name = scanner.nextLine();
                    manager.registerUser(new User(userId, name));
                    break;
                case "6":
                    manager.viewUsers();
                    break;
                case "7":
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (!choice.equals("7"));

        scanner.close();
    }
}
