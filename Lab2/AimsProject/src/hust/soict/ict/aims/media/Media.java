package hust.soict.ict.aims.media;

public abstract class Media {
    private static int nbMedia = 0;
    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    public Media() {
        this.id = ++nbMedia;
    }

    public Media(String title, String category, float cost) {
        this();
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Getters and setters for title, category, and cost
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

    // Getter for id
    public int getId() {
        return id;
    }
}
