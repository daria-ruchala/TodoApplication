public class Task {
    private final int id;
    private final String title;
    private final String category;
    private boolean status;

    //constructor
    public Task(int id, String title, String category) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.status = false; //hardcoded every parameter starts as not done
    }

    //getters and setters
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

}
