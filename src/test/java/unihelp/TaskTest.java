package unihelp;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class TaskTest {

    @Test
    void taskCreation_andCSVConversion() {
        Task task = new Task("Test Task");
        assertEquals("Test Task", task.getTitle());
        assertFalse(task.isComplete());

        task.markComplete();
        assertTrue(task.isComplete());

        String csv = task.toCSV();
        Task fromCsv = Task.fromCSV(csv);
        assertNotNull(fromCsv);
        assertEquals(task.getTitle(), fromCsv.getTitle());
        assertEquals(task.isComplete(), fromCsv.isComplete());
    }
}
