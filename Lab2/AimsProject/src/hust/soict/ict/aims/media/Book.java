package hust.soict.ict.aims.media;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Book extends Object {
    private int id;
    private String title;
    private String category;
    private float cost;
    private ArrayList<String> authors;

    // Constructors
    public Book() {
        // Default constructor
    }

    public Book(int id, String title, String category, float cost, ArrayList<String> authors) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.authors = authors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }
    
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
        else {
        	JOptionPane.showMessageDialog(null, "This author is exist", "Author", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to remove an author from the list
    public void removeAuthor(String authorName) {
    	if (!authors.contains(authorName)) {
    		JOptionPane.showMessageDialog(null, "This author is not exist", "Author", JOptionPane.ERROR_MESSAGE);
        }
        else {
        	authors.remove(authorName);
        	
        }
    }
}
