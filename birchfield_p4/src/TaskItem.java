public class TaskItem {
    private String title;
    private String description;
    private String dueDate;
    private boolean completed;

    public TaskItem(String title, String description, String dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
    }

    public void setCompleted(boolean complete) {
        this.completed = complete;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s: %s", this.dueDate, this.title, this.description);
    }
}
