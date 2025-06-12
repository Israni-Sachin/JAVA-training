import java.io.*;
import java.util.*;

public class FileManager {
    private static final String FILE_PATH = "books.dat";

    public static void saveBooks(List<Book> books) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Book> loadBooks() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading books: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
