import java.io.Serializable;

public class Book implements Serializable {
    private String title, author, genre;
    private int copies;
    private int timesBorrowed;

    public Book(String title, String author, String genre, int copies) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.copies = copies;
        this.timesBorrowed = 0;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public int getCopies() { return copies; }
    public int getTimesBorrowed() { return timesBorrowed; }

    public void borrow() {
        if (copies > 0) {
            copies--;
            timesBorrowed++;
        }
    }

    public void returnBook() {
        copies++;
    }

    public boolean isAvailable() {
        return copies > 0;
    }

    public String toString() {
        return String.format("Title: %s | Author: %s | Genre: %s | Copies: %d | Times Borrowed: %d",
                title, author, genre, copies, timesBorrowed);
    }
}
