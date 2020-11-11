import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
        Assertions.assertThrows(InvalidDateException.class, () -> {
            new TaskItem("Test", "this is a description", "2020-11-31");
        });
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        Assertions.assertThrows(InvalidTitleException.class, () -> {
            new TaskItem("", "this is a description", "2020-11-09");
        });
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        TaskItem t = new TaskItem("Test", "this is a description", "2020-11-09");
        assertEquals("2020-11-09", t.getDueDate());
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        TaskItem t = new TaskItem("Test", "this is a description", "2020-11-09");
        assertEquals("Test", t.getTitle());
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {
        TaskItem t = new TaskItem("Test", "this is a description", "2020-11-09");
        Assertions.assertThrows(InvalidDateException.class, () -> {
            t.setDueDate("2020-11-31");
        });
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        TaskItem t = new TaskItem("Test", "this is a description", "2020-11-09");
        t.setDueDate("2020-11-08");
        assertEquals("2020-11-08", t.getDueDate());
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        TaskItem t = new TaskItem("Test", "this is a description", "2020-11-09");
        Assertions.assertThrows(InvalidTitleException.class, () -> {
            t.setTitle("");
        });
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        TaskItem t = new TaskItem("Test", "this is a description", "2020-11-09");
        t.setTitle("Title");
        assertEquals("Title", t.getTitle());
    }

}