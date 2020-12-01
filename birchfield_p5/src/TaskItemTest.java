import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    public void constructorFailsWithInvalidDueDate() {
        Assertions.assertThrows(InvalidDateException.class, () -> {
            new TaskItem("Test", "this is a description", "2020-11-31");
        });
    }

    @Test
    public void constructorFailsWithInvalidTitle() {
        Assertions.assertThrows(InvalidTitleException.class, () -> {
            new TaskItem("", "this is a description", "2020-11-09");
        });
    }

    @Test
    public void constructorSucceedsWithValidDueDate() {
        TaskItem t = new TaskItem("Test", "this is a description", "2020-11-09");
        assertEquals("2020-11-09", t.getDueDate());
    }

    @Test
    public void constructorSucceedsWithValidTitle() {
        TaskItem t = new TaskItem("Test", "this is a description", "2020-11-09");
        assertEquals("Test", t.getTitle());
    }

    @Test
    public void editingDueDateFailsWithInvalidYYYMMDD() {
        TaskItem t = new TaskItem("Test", "this is a description", "2020-11-09");
        Assertions.assertThrows(InvalidDateException.class, () -> {
            t.setDueDate("2020-11-31");
        });
    }

    @Test
    public void editingDueDateFailsWithInvalidDateFormat() {
        TaskItem t = new TaskItem("Test", "this is a description", "2020-11-09");
        Assertions.assertThrows(InvalidDateException.class, () -> {
            t.setDueDate("11-22-2020");
        });
    }

    @Test
    public void editingDueDateSucceedsWithExpectedValue() {
        TaskItem t = new TaskItem("Test", "this is a description", "2020-11-09");
        t.setDueDate("2020-11-08");
        assertEquals("2020-11-08", t.getDueDate());
    }

    @Test
    public void editingDescriptionSucceedsWithExpectedValue() {
        TaskItem t = new TaskItem("Test", "this is a description", "2020-11-09");
        t.setDescription("new description");
        assertEquals("new description", t.getDescription());
    }

    @Test
    public void editingTitleFailsWithEmptyString() {
        TaskItem t = new TaskItem("Test", "this is a description", "2020-11-09");
        Assertions.assertThrows(InvalidTitleException.class, () -> {
            t.setTitle("");
        });
    }

    @Test
    public void editingTitleSucceedsWithExpectedValue() {
        TaskItem t = new TaskItem("Test", "this is a description", "2020-11-09");
        t.setTitle("Title");
        assertEquals("Title", t.getTitle());
    }

}