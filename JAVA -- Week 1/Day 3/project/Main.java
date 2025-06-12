import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Library library = new Library();
    static User currentUser;

    public static void main(String[] args) {
        login();

        int choice;
        do {
            showMenu();
            choice = Integer.parseInt(sc.nextLine());
            handleChoice(choice);
        } while (choice != 7);

        library.saveLibrary();
        System.out.println("Library data saved. Goodbye!");
    }

    static void login() {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter role (Librarian/Student): ");
        String role = sc.nextLine();
        currentUser = new User(username, role);
    }

    static void showMenu() {
        System.out.println("\n--- Library Menu ---");
        if (currentUser.isLibrarian()) {
            System.out.println("1. Add Book");
        }
        System.out.println("2. View All Books");
        System.out.println("3. Search Book");
        System.out.println("4. Borrow Book");
        System.out.println("5. Return Book");
        System.out.println("6. Show Top Borrowed Books");
        System.out.println("7. Exit");
        System.out.print("Choose an option: ");
    }

    static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                if (currentUser.isLibrarian()) {
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Copies: ");
                    int copies = Integer.parseInt(sc.nextLine());
                    library.addBook(new Book(title, author, genre, copies));
                } else {
                    System.out.println("Access denied. Only librarians can add books.");
                }
                break;
            case 2:
                library.viewBooks();
                break;
            case 3:
                System.out.print("Search by (title/author/genre): ");
                String field = sc.nextLine();
                System.out.print("Enter keyword: ");
                String keyword = sc.nextLine();
                library.searchBooks(keyword, field);
                break;
            case 4:
                System.out.print("Enter title to borrow: ");
                library.borrowBook(sc.nextLine());
                break;
            case 5:
                System.out.print("Enter title to return: ");
                library.returnBook(sc.nextLine());
                break;
            case 6:
                System.out.println("Top 3 Most Borrowed Books:");
                library.showTopBorrowedBooks(3);
                break;
            case 7:
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
