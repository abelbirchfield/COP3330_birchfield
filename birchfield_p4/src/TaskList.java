import java.util.ArrayList;

public class TaskList {
    private ArrayList<TaskItem> tasks;

    public TaskList() {
        this.tasks = new ArrayList<TaskItem>();
    }

//    public ArrayList<TaskItem> getTasks() {
//        return tasks;
//    }

    public void addTask(TaskItem newTask) {
        tasks.add(newTask);
    }
    public void removeTask(int index) {
        tasks.remove(index);
    }
    public void editTaskList(int index, TaskItem newTask) {
        tasks.set(index, newTask);
    }

    public void complete(int index) {
        tasks.get(index).setCompleted(true);
    }
    public void incomplete(int index) {
        tasks.get(index).setCompleted(false);
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