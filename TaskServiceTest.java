package grandStrandSystems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
	private TaskService taskService;
	
	@BeforeEach
	public void setUp() {
		taskService = new TaskService();
	}
	
	// Test addTask method
	@Test
	public void testAddTask() {
		taskService.addTask("1234567890", "Go shopping", "Go to the mall");
		assertNotNull(taskService.getTask("1234567890"), "Task should be added successfully");
	}
	
	@Test
    public void testAddTaskWithDuplicateID() {
        taskService.addTask("1234567890", "Go shopping", "Go to the mall");
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask("1234567890", "Go shopping", "Go to the mall");
        }, "Should throw exception for duplicate ID");
    }
	
	// Test getTask method
	@Test
	public void testGetTask() {
		taskService.addTask("1234567890", "Go shopping", "Go to the mall");
		Task task = taskService.getTask("1234567890");
		assertEquals("Go shopping", task.getTaskName(), "Retrieved task should have correct task name");
	}
	
	@Test
	public void testGetNonExistentTask() {
		assertNull(taskService.getTask("nonexistent"), "Should return null for a non-existent task ID");
	}
	
	// Test updateTask method
	@Test
	public void testUpdateTaskName() {
	    taskService.addTask("1234567890", "Go shopping", "Go to the mall");
	    taskService.updateTaskName("1234567890", "Go grocery shopping");
	    Task updatedTask = taskService.getTask("1234567890");
	    assertEquals("Go grocery shopping", updatedTask.getTaskName(), "Task name should be updated.");
	}
	
	@Test
	public void testUpdateTaskDescription() {
	    taskService.addTask("1234567890", "Go shopping", "Go to the mall");
	    taskService.updateTaskDescription("1234567890", "Go to Orange Park Mall");
	    Task updatedTask = taskService.getTask("1234567890");
	    assertEquals("Go to Orange Park Mall", updatedTask.getTaskDescription(), "Task description should be updated.");
	}
	
	@Test
	public void testUpdateTaskNameNonExistentTask() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        taskService.updateTaskName("nonexistent", "Go shopping");
	    }, "Should throw exception when updating the name of a non-existent task");
	}
	
	@Test
	public void testUpdateTaskDescriptionNonExistentTask() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        taskService.updateTaskDescription("nonexistent", "Go to Orange Park Mall");
	    }, "Should throw exception when updating the description of a non-existent task");
	}
	
	// Test deleteTask method
	@Test
	public void testDeleteTask() {
		taskService.addTask("1234567890", "Go shopping", "Go to Orange Park Mall");
		taskService.deleteTask("1234567890");
		assertNull(taskService.getTask("1234567890"), "Task should be deleted successfully");
	}
}