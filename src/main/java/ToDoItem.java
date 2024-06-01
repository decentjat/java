import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {

    @Test
    public void testAddItem() {
        ToDoList toDoList = new ToDoList();
        ToDoItem item = toDoList.addItem("Test ToDo");
        assertNotNull(item);
        assertEquals(1, item.getId());
        assertEquals("Test ToDo", item.getDescription());
        assertFalse(item.isCompleted());
    }

    @Test
    public void testUpdateItem() {
        ToDoList toDoList = new ToDoList();
        toDoList.addItem("Test ToDo");
        boolean updated = toDoList.updateItem(1, "Updated ToDo", true);
        assertTrue(updated);
        ToDoItem item = toDoList.getItem(1).orElse(null);
        assertNotNull(item);
        assertEquals("Updated ToDo", item.getDescription());
        assertTrue(item.isCompleted());
    }

    @Test
    public void testDeleteItem() {
        ToDoList toDoList = new ToDoList();
        toDoList.addItem("Test ToDo");
        boolean deleted = toDoList.deleteItem(1);
        assertTrue(deleted);
        assertTrue(toDoList.getItems().isEmpty());
    }
}

