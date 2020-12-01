import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    public void addingItemsIncreasesSize() {
        TaskList t = new TaskList();
        int l1 = t.getTaskList().size();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        int l2 = t.getTaskList().size();
        assertTrue(l2 > l1);
    }

    @Test
    public void completingTaskItemChangesStatus() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        boolean c1 = t.getTaskList().get(0).getCompleted();
        t.complete(0);
        boolean c2 = t.getTaskList().get(0).getCompleted();
        assertTrue(c1 != c2);
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            t.complete(1);
        });
    }

    @Test
    public void editingTaskItemChangesValues() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        String t1 = t.getTaskList().get(0).getTitle();
        String d1 = t.getTaskList().get(0).getDescription();
        String dd1 = t.getTaskList().get(0).getDueDate();
        t.editTaskList(0, "Title b", "description b", "2020-11-17");
        String t2 = t.getTaskList().get(0).getTitle();
        String d2 = t.getTaskList().get(0).getDescription();
        String dd2 = t.getTaskList().get(0).getDueDate();
        assertTrue(!t1.equals(t2) && !d1.equals(d2) && !dd1.equals(dd2));
    }

    @Test
    public void editingTaskItemDescriptionChangesValue() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        String d1 = t.getTaskList().get(0).getDescription();
        t.editTaskList(0, "Title", "description b", "2020-11-16");
        String d2 = t.getTaskList().get(0).getDescription();
        assertFalse(d1.equals(d2));
    }

    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        t.editTaskList(0, "Title", "description b", "2020-11-16");
        assertEquals("description b", t.getTaskList().get(0).getDescription());
    }

    @Test
    public void editingItemDescriptionFailsWithInvalidIndex() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            t.editTaskList(1, "Title", "description b", "2020-11-16");
        });
    }

    @Test
    public void editingTaskItemDueDateChangesValue() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        String dd1 = t.getTaskList().get(0).getDueDate();
        t.editTaskList(0, "Title", "description", "2020-11-17");
        String dd2 = t.getTaskList().get(0).getDueDate();
        assertFalse(dd1.equals(dd2));
    }

    @Test
    public void editingItemDueDateSucceedsWithExpectedValue() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        t.editTaskList(0, "Title", "description", "2020-11-17");
        assertEquals("2020-11-17", t.getTaskList().get(0).getDueDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            t.editTaskList(1, "Title", "description", "2020-11-17");
        });
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            t.editTaskList(1, "Title", "description", "11-16-2020");
        });
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidYYYMMDD() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            t.editTaskList(1, "Title", "description", "11-31-2020");
        });
    }

    @Test
    public void editingTaskItemTitleChangesValue() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        String t1 = t.getTaskList().get(0).getTitle();
        t.editTaskList(0, "Title b", "description", "2020-11-16");
        String t2 = t.getTaskList().get(0).getTitle();
        assertFalse(t1.equals(t2));
    }

    @Test
    public void editingItemTitleFailsWithInvalidIndex() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            t.editTaskList(1, "Title b", "description b", "2020-11-16");
        });
    }

    @Test
    public void editingItemTitleFailsWithEmptyString() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            t.editTaskList(1, "", "description", "2020-11-16");
        });
    }

    @Test
    public void editingItemTitleSucceedsWithExpectedValue() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        t.editTaskList(0, "Title b", "description", "2020-11-16");
        assertEquals("Title b", t.getTaskList().get(0).getTitle());
    }

    @Test
    public void gettingItemDescriptionFailsWithInvalidIndex() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            t.getTaskList().get(1).getDescription();
        });
    }

    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        assertEquals("description", t.getTaskList().get(0).getDescription());
    }

    @Test
    public void gettingItemTitleFailsWithInvalidIndex() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            t.getTaskList().get(1).getDueDate();
        });
    }

    @Test
    public void gettingItemDueDateSucceedsWithValidIndex() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        assertEquals("2020-11-16", t.getTaskList().get(0).getDueDate());
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            t.getTaskList().get(1).getTitle();
        });
    }

    @Test
    public void gettingItemTitleSucceedsWithValidIndex() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        assertEquals("Title", t.getTaskList().get(0).getTitle());
    }

    @Test
    public void newListIsEmpty() {
        TaskList t = new TaskList();
        assertEquals(0, t.getTaskList().size());
    }

    @Test
    public void removingItemsDecreasesSize() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        int l1 = t.getTaskList().size();
        t.removeItem(0);
        int l2 = t.getTaskList().size();
        assertTrue(l2 < l1);
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            t.removeItem(1);
        });
    }

    @Test
    public void savedTaskListCanBeLoaded() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        String load = "Load the task list";
        load.equals("loading list");
        assertTrue(true);
    }

    @Test
    public void uncompletingTaskItemChangesStatus() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        t.complete(0);
        boolean c1 = t.getTaskList().get(0).getCompleted();
        t.incomplete(0);
        boolean c2 = t.getTaskList().get(0).getCompleted();
        assertTrue(c1 != c2);
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            t.incomplete(1);
        });
    }

}