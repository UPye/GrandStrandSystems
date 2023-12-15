package grandStrandSystems;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
	private Map<String, Task> taskMap = new HashMap<>();
	
	// Method to add a task
	public void addTask (String taskID, String taskName, String taskDescription) {
		if (!taskMap.containsKey(taskID)) {
			Task newTask = new Task(taskID, taskName, taskDescription);
			taskMap.put(taskID, newTask);
		}
		
		else {
			throw new IllegalArgumentException("A task already exists with this ID.");
		}
	}
	
	public Task getTask (String taskID) {
		return taskMap.get(taskID);
	}
	
	public void deleteTask (String taskID) {
		taskMap.remove(taskID);
	}
	
	public void updateTaskName(String taskID, String taskName) {
		if (taskMap.containsKey(taskID)) {
			Task taskToUpdate = taskMap.get(taskID);
			taskToUpdate.setTaskName(taskName);
		}
		
		else {
			throw new IllegalArgumentException("No task exists with this ID");
		}
	}
	
	public void updateTaskDescription(String taskID, String taskDescription) {
		if (taskMap.containsKey(taskID)) {
			Task taskToUpdate = taskMap.get(taskID);
			taskToUpdate.setTaskDescription(taskDescription);
		}
		
		else {
			throw new IllegalArgumentException("No task exists with this ID");
		}
	}
}