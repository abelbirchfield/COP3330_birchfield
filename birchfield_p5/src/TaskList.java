import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TaskList extends ItemList {
    private ArrayList<TaskItem> tasks;

    public TaskList() {
        this.tasks = new ArrayList<TaskItem>();
    }

    public ArrayList<TaskItem> getTaskList() {
        return this.tasks;
    }

    public void addTask(TaskItem newTask) {
        tasks.add(newTask);
    }
    public void removeItem(int index) {
        tasks.remove(index);
    }
    public void editTaskList(int index, String title, String description, String dueDate) {
        try {
            tasks.get(index).setTitle(title);
            tasks.get(index).setDescription(description);
            tasks.get(index).setDueDate(dueDate);
        } catch (InvalidTitleException e) {
            System.out.println("WARNING: title must be at least 1 character long; task not edited");
        } catch (InvalidDateException e) {
            System.out.println("WARNING: invalid due date; task not edited");
        }
    }

    public void complete(int index) {
        tasks.get(index).setCompleted(true);
    }
    public void incomplete(int index) {
        tasks.get(index).setCompleted(false);
    }

    public void save(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.createNewFile()) {
                System.out.println("File already exists");
            }
            FileWriter writer = new FileWriter(fileName);
            writer.write(this.toString());
            writer.close();
            System.out.println("task list has been saved");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    @Override
    public String toString() {
        String output = "";
        for(int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getCompleted()) {
                output += String.format("%d) *** %s%n", i, tasks.get(i));
            } else {
                output += String.format("%d) %s%n", i, tasks.get(i));
            }
        }
        return output;
    }
    public String toStringUncompleted() {
        String output = "";
        for(int i = 0; i < tasks.size(); i++) {
            if(!tasks.get(i).getCompleted()) {
                output += String.format("%d) %s%n", i, tasks.get(i));
            }
        }
        return output;
    }
    public String toStringCompleted() {
        String output = "";
        for(int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getCompleted()) {
                output += String.format("%d) %s%n", i, tasks.get(i));
            }
        }
        return output;
    }
}