import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest { //24
    @Test
    public void addingTaskItemsIncreasesSize(){
        TaskList tasks = new TaskList();
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");

        tasks.addTask(t);

        assertEquals(1, tasks.getSize());
    }

    @Test
    public void completingTaskItemChangesStatus(){
        TaskList tasks = new TaskList();
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        tasks.addTask(t);

        tasks.updateStatus(true, 0);

        assertEquals(true, tasks.tasks.get(0).getStatus());
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskList tasks = new TaskList();
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        tasks.addTask(t);

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.updateStatus(true, 1));
    }

    @Test
    public void editingTaskItemChangesValues(){
        TaskList tasks = new TaskList();
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        tasks.addTask(t);

        TaskItem newTask = new TaskItem("Title2", "Description2", "2020-02-22");

        tasks.editTask(0, newTask);

        assertNotEquals(t, tasks.tasks.get(0));
    }

    @Test
    public void editingTaskItemDescriptionChangesValue(){
        TaskList tasks = new TaskList();
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        tasks.addTask(t);

        TaskItem newTask = new TaskItem("Title2", "Description", "2020-02-20");
        tasks.editTask(0, newTask);

        assertEquals("Title2", tasks.tasks.get(0).getTitle());
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList tasks = new TaskList();
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        tasks.addTask(t);

        TaskItem newTask = new TaskItem("Title", "Description2", "2020-02-20");

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.editTask(2, newTask));
    }

    @Test
    public void editingTaskItemDueDateChangesValue(){
        TaskList tasks = new TaskList();
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        tasks.addTask(t);

        TaskItem newTask = new TaskItem("Title", "Description2", "2020-02-20");
        tasks.editTask(0, newTask);

        assertEquals("Description2", tasks.tasks.get(0).getDescription());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList tasks = new TaskList();
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        tasks.addTask(t);

        TaskItem newTask = new TaskItem("Title", "Description", "2020-02-25");

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.editTask(2, newTask));
    }

    @Test
    public void editingTaskItemTitleChangesValue(){
        TaskList tasks = new TaskList();
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        tasks.addTask(t);

        TaskItem newTask = new TaskItem("Title", "Description", "4444-44-44");
        tasks.editTask(0, newTask);

        assertEquals("4444-44-44", tasks.tasks.get(0).getDueDate());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){
        TaskList tasks = new TaskList();
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        tasks.addTask(t);

        TaskItem newTask = new TaskItem("Title2", "Description", "2020-02-20");

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.editTask(2, newTask));
    }

    @Test
    public void gettingItemDescriptionFailsWithInvalidIndex() {
        TaskList tasks = new TaskList();
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        tasks.addTask(t);

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.getItemDescription(2));
    }

    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex(){
        TaskList tasks = new TaskList();
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        tasks.addTask(t);

        assertDoesNotThrow(() -> tasks.getItemDescription(0));
    }

    @Test
    public void gettingItemDueDateFailsWithInvalidIndex(){
        TaskList tasks = new TaskList();
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        tasks.addTask(t);

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.getItemDueDate(2));
    }

    @Test
    public void gettingItemDueDateSucceedsWithValidIndex(){
        TaskList tasks = new TaskList();
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        tasks.addTask(t);

        assertDoesNotThrow(() -> tasks.getItemDueDate(0));
    }

    @Test
    public void gettingItemTitleFailsWithInvalidIndex(){
        TaskList tasks = new TaskList();
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        tasks.addTask(t);

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.getItemTitle(2));
    }

    @Test
    public void gettingItemTitleSucceedsWithValidIndex(){
        TaskList tasks = new TaskList();
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        tasks.addTask(t);

        assertDoesNotThrow(() -> tasks.getItemTitle(0));
    }

    @Test
    public void newTaskListIsEmpty(){
        TaskList tasks = new TaskList();

        assertEquals(0, tasks.getSize());
    }

    @Test
    public void removingTaskItemsDecreasesSizeOneTask(){
        TaskList tasks = new TaskList();
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");

        tasks.addTask(t);
        tasks.removeTask(0);

        assertEquals(0, tasks.getSize());
    }

    @Test
    public void removingTaskItemsDecreasesSizeTwoTasks(){
        TaskList tasks = new TaskList();
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        TaskItem t2 = new TaskItem("Title2", "Description2", "2020-02-22");

        tasks.addTask(t);
        tasks.addTask(t2);
        tasks.removeTask(1);

        assertEquals(1, tasks.getSize());
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){
        TaskList tasks = new TaskList();
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        tasks.addTask(t);

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.removeTask(1));
    }

    @Test
    public void savedTaskListCanBeLoaded(){
        TaskList tasks = new TaskList();
        TaskItem t = new TaskItem("Title", "Description", "4444-44-44");

        tasks.addTask(t);
        tasks.write("TEST_CASE.txt");
        TaskList tasks2 = new TaskList();
        tasks2.read("TEST_CASE.txt");

        assertEquals("4444-44-44", tasks.tasks.get(0).getDueDate());
    }

    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskList tasks = new TaskList();
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        tasks.addTask(t);

        tasks.updateStatus(true, 0);
        tasks.updateStatus(false, 0);

        assertEquals(false, tasks.tasks.get(0).getStatus());
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskList tasks = new TaskList();
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        tasks.addTask(t);

        tasks.updateStatus(true, 0);

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.updateStatus(false, 1));
    }
}