package grandStrandSystems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskTest {
	private Task task;
	
	@BeforeEach
	public void setUp() {
		task = new Task("1234567890", "Go grocery shopping", "Pick up ground beef, lasgna pasta, & pasta sauce.");
	}
	
	// Test Constructor
	@Test
	public void testTaskConstructorValidData() {
		assertEquals("Go grocery shopping", task.getTaskName(), "Task name doesn't match expected value.");
		assertEquals("Pick up ground beef, lasgna pasta, & pasta sauce.", task.getTaskDescription(), "Task description doesn't match expected value.");
		
	}
	
	@Test
	public void testTaskConstructorInvalidData() {
		assertThrows(IllegalArgumentException.class, () -> new Task(null, "Go grocery shopping", "Pick up ground beef, lasgna pasta, & pasta sauce."));
		assertThrows(IllegalArgumentException.class, () -> new Task("445566", null, "Pick up ground beef, lasgna pasta, & pasta sauce."));
		assertThrows(IllegalArgumentException.class, () -> new Task("445566", "Go grocery shopping", null));
	}
	
	// Test Setters
	@Test
	public void testSetTaskNameValid() {
		task.setTaskName("Wash Car");
	}
	
	public void testSetTaskDescriptionValid() {
		task.setTaskDescription("Wash car at auto car wash.");
	}
	
	@Test
	public void testSetTaskNameInvalid() {
		assertThrows(IllegalArgumentException.class, () -> task.setTaskName(null));
	}
	
	public void testSetTaskDescriptionInvalid() {
		assertThrows(IllegalArgumentException.class, () -> task.setTaskDescription(null));
	}
	
	// Test Getters
	@Test
	public void testGetTaskName() {
		assertEquals("Go shopping", task.getTaskName(), "Getter for task name failed");
	}
	
	public void testGetTaskDescription() {
		assertEquals("Go shopping at the mall", task.getTaskDescription(), "Getter for task name failed");
	}
	
	// Test toString Method
    @Test
    public void testToString() {
        String expectedString = "Task{ID='1234567890'taskName='Go shopping', taskDescription='Go shopping at the mall'}";
        assertEquals(expectedString, task.toString(), "toString does not match the expected format");
    }
}
