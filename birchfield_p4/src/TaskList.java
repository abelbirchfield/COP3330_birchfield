import java.util.ArrayList;

public class TaskList {
    private ArrayList<TaskItem> tasks;

    public TaskList() {
        this.tasks = new ArrayList<TaskItem>();
    }

    public ArrayList<TaskItem> getTasks() {
        return tasks;
    }

    public void addTask(TaskItem newTask) {
        tasks.add(newTask);
    }
    public void removeTask(int index) {
        tasks.remove(index);
    }

    public void editTaskList(int index, String field, String newValue) {
        //set variable field = newValue for object at index in tasks
    }

    public void complete(int index) {
        tasks.get(index).setCompleted(true);
    }
    public void incomplete(int index) {
        tasks.get(index).setCompleted(false);
    }


}