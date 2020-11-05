import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
        TaskItem t = new TaskItem("Test", "this is a description", "2020-11-09");
        //assertEquals();
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        TaskItem t = new TaskItem("Test", "this is a description", "2020-11-09");
        //assertEquals();
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        TaskItem t = new TaskItem("Test", "this is a description", "2020-11-09");
        //assertEquals();
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        TaskItem t = new TaskItem("Test", "this is a description", "2020-11-09");
        //assertEquals();
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {
        TaskItem t = new TaskItem("Test", "this is a description", "2020-11-09");
        //assertEquals();
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        TaskItem t = new TaskItem("Test", "this is a description", "2020-11-09");
        //assertEquals();
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        TaskItem t = new TaskItem("Test", "this is a description", "2020-11-09");
        //assertEquals();
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        TaskItem t = new TaskItem("Test", "this is a description", "2020-11-09");
        //assertEquals();
    }

}