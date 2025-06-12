import java.util.*;

public class Library {
    private List<Book> books;

    public Library() {
        books = FileManager.loadBooks();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            books.forEach(System.out::println);
        }
    }

    public void searchBooks(String keyword, String field) {
        keyword = keyword.toLowerCase();
        boolean found = false;

        for (Book b : books) {
            switch (field) {
                case "title": b.getTitle().toLowerCase().contains(keyword);System.out.println(b);
                    found = true;
                case "author" : b.getAuthor().toLowerCase().contains(keyword);System.out.println(b);
                    found = true;
                case "genre" : b.getGenre().toLowerCase().contains(keyword);System.out.println(b);
                    found = true;
                default : System.out.println("Invalid search option.");
                    return;
            }

        }

        if (!found) System.out.println("No matching books found.");
    }

    public void borrowBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                if (b.isAvailable()) {
                    b.borrow();
                    System.out.println("Book borrowed successfully.");
                } else {
                    System.out.println("Book is currently unavailable.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                b.returnBook();
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void showTopBorrowedBooks(int topN) {
        books.stream()
                .sorted((a, b) -> Integer.compare(b.getTimesBorrowed(), a.getTimesBorrowed()))
                .limit(topN)
                .forEach(System.out::println);
    }

    public void saveLibrary() {
        FileManager.saveBooks(books);
    }
}
