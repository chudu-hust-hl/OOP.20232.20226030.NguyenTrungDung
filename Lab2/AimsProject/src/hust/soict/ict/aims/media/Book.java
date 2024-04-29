package hust.soict.ict.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors;

    public Book(String title) {
        super();
        this.title = title;
        authors = new ArrayList<>();
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
        authors = new ArrayList<>();
    }

    public Book(String title, String category, ArrayList<String> authors, float cost) {
        super(title, category, cost);
        this.authors = authors;
    }

    // Getters and setters for authors
    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    // Method to add an author
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    // Method to remove an author
    public void removeAuthor(String authorName) {
        authors.remove(authorName);
    }
}
