import java.util.*;

class Book {
    String title;
    String author;
    String genre;
    int copies;

    public Book(String title, String author, String genre, int copies) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.copies = copies;
    }

    public String toString() {
        return String.format("Title: %s | Author: %s | Genre: %s | Available Copies: %d",
                title, author, genre, copies);
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Book> bookList = new ArrayList<>();

    public static void main(String[] args) {
        int choice = 0;
        String ans;
        do {
            System.out.println("Want to do any operations with library management system? (y/n)");
            ans = sc.nextLine();
            if(ans.equals("y")){
                showMenu();
                choice = getChoice();
                switch (choice) {
                    case 1: addBook(); break;
                    case 2: viewBooks(); break;
                    case 3: searchBooks(); break;
                    case 4: borrowBook(); break;
                    case 5: returnBook(); break;
                    case 6: System.out.println("Exiting system. Goodbye!"); ans="n"; break;
                    default: System.out.println("Invalid option. Try again.");
                }
            }
            else if(ans.equals("n")) {
                System.out.println("Exiting system. Goodbye!");
                break;
            }
            else{
                System.out.println("Invalid option. Try again.");
            }

        } while (!ans.equals("n"));
    }

    static void showMenu() {
        System.out.println("\n====== Library Management System ======");
        System.out.println("1. Add New Book");
        System.out.println("2. View All Books");
        System.out.println("3. Search Book (Title, Author, Genre)");
        System.out.println("4. Borrow Book");
        System.out.println("5. Return Book");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    static int getChoice() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    static void addBook() {
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();
        System.out.print("Enter Genre: ");
        String genre = sc.nextLine();
        System.out.print("Enter Number of Copies: ");
        int copies = Integer.parseInt(sc.nextLine());

        bookList.add(new Book(title, author, genre, copies));
        System.out.println("Book added successfully!");
    }

    static void viewBooks() {
        if (bookList.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("\n--- List of Books ---");
            for (Book book : bookList) {
                System.out.println(book);
            }
        }
    }

    static void searchBooks() {
        System.out.print("Search by (1. Title, 2. Author, 3. Genre): ");
        int option = Integer.parseInt(sc.nextLine());
        System.out.print("Enter search keyword: ");
        String keyword = sc.nextLine().toLowerCase();

        boolean found = false;
        for (Book book : bookList) {
            switch (option) {
                case 1:
                    if (book.title.toLowerCase().contains(keyword)) {
                        System.out.println(book);
                        found = true;
                    }
                    break;
                case 2:
                    if (book.author.toLowerCase().contains(keyword)) {
                        System.out.println(book);
                        found = true;
                    }
                    break;
                case 3:
                    if (book.genre.toLowerCase().contains(keyword)) {
                        System.out.println(book);
                        found = true;
                    }
                    break;
                default:
                    System.out.println("Invalid search option.");
                    return;
            }
        }
        if (!found) System.out.println("No books matched your search.");
    }

    static void borrowBook() {
        System.out.print("Enter title of the book to borrow: ");
        String title = sc.nextLine().toLowerCase();

        for (Book book : bookList) {
            if (book.title.toLowerCase().equals(title)) {
                if (book.copies > 0) {
                    book.copies--;
                    System.out.println("Book borrowed successfully!");
                } else {
                    System.out.println("Book currently not available.");
                }
                return;
            }
        }
        System.out.println("Book not found in library.");
    }

    static void returnBook() {
        System.out.print("Enter title of the book to return: ");
        String title = sc.nextLine().toLowerCase();

        for (Book book : bookList) {
            if (book.title.toLowerCase().equals(title)) {
                book.copies++;
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Book not found in library records.");
    }
}
