import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize() {
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

//    @Test
//    public void completingTaskItemFailsWithInvalidIndex() {
//        TaskList t = new TaskList();
//        //assertEquals();
//    }

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
//
//    @Test
//    public void editingTaskItemDescriptionFailsWithInvalidIndex() {
//        TaskList t = new TaskList();
//        //assertEquals();
//    }
//
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
//
//    @Test
//    public void editingTaskItemDueDateFailsWithInvalidIndex() {
//        TaskList t = new TaskList();
//        //assertEquals();
//    }
//
    @Test
    public void editingTaskItemTitleChangesValue() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        String t1 = t.getTaskList().get(0).getTitle();
        t.editTaskList(0, "Title b", "description", "2020-11-17");
        String t2 = t.getTaskList().get(0).getTitle();
        assertFalse(t1.equals(t2));
    }
//
//    @Test
//    public void editingTaskItemTitleFailsWithInvalidIndex() {
//        TaskList t = new TaskList();
//        //assertEquals();
//    }
//
//    @Test
//    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
//        TaskList t = new TaskList();
//        //assertEquals();
//    }
//
    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        assertEquals("description", t.getTaskList().get(0).getDescription());
    }
//
//    @Test
//    public void gettingTaskItemDueDateFailsWithInvalidIndex() {
//        TaskList t = new TaskList();
//        //assertEquals();
//    }
//
    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        assertEquals("2020-11-16", t.getTaskList().get(0).getDueDate());
    }
//
//    @Test
//    public void gettingTaskItemTitleFailsWithInvalidIndex() {
//        TaskList t = new TaskList();
//        //assertEquals();
//    }
//
    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        assertEquals("Title", t.getTaskList().get(0).getTitle());
    }

    @Test
    public void newTaskListIsEmpty() {
        TaskList t = new TaskList();
        assertEquals(0, t.getTaskList().size());
    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        TaskList t = new TaskList();
        TaskItem a = new TaskItem("Title", "description", "2020-11-16");
        t.addTask(a);
        int l1 = t.getTaskList().size();
        t.removeTask(0);
        int l2 = t.getTaskList().size();
        assertTrue(l2 < l1);
    }

//    @Test
//    public void removingTaskItemsFailsWithInvalidIndex() {
//        TaskList t = new TaskList();
//        //assertEquals();
//    }
//
//    @Test
//    public void savedTaskListCanBeLoaded() {
//        TaskList t = new TaskList();
//        assertTrue(true);
//    }

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

//    @Test
//    public void uncompletingTaskItemFailsWithInvalidIndex() {
//        TaskList t = new TaskList();
//        //assertEquals();
//    }

}