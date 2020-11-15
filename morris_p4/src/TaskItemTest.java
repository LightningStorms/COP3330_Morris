import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        assertThrows(InvalidDateException.class, () -> new TaskItem("Title", "Description", "20-20-2020"));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidDueDateTooLong(){
        assertThrows(InvalidDateException.class, () -> new TaskItem("Title", "Description", "2020-20-2020"));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidDueDateTooShort(){
        assertThrows(InvalidDateException.class, () -> new TaskItem("Title", "Description", "2020-20-"));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        assertDoesNotThrow(() -> new TaskItem("Title", "Description", "2020-02-20"));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        assertThrows(InvalidTitleException.class, () -> new TaskItem("T", "Description", "2020-02-20"));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        assertDoesNotThrow(() -> new TaskItem("Title", "Description", "2020-02-20"));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidDescription(){
        assertThrows(InvalidDescriptionException.class,() -> new TaskItem("Title", "", "2020-02-20"));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDescription(){
        assertDoesNotThrow(() -> new TaskItem("Title", "Description", "2020-02-20"));
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate(){
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        assertThrows(InvalidDateException.class, () -> t.setDueDate(""));
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        assertDoesNotThrow(() -> t.setDueDate("2019-02-20"));
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        assertThrows(InvalidTitleException.class, () -> t.setTitle("T"));
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        assertDoesNotThrow(() -> t.setTitle("Title"));
    }

    @Test
    public void settingTaskItemDescriptionFailsWithInvalidDescription(){
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        assertThrows(InvalidDescriptionException.class,() -> t.setDescription(""));
    }

    @Test
    public void settingTaskItemDescriptionSucceedsWithValidDescription(){
        TaskItem t = new TaskItem("Title", "Description", "2020-02-20");
        assertDoesNotThrow(() -> t.setDescription("Description"));
    }
}