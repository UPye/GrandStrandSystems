package grandStrandSystems;

public class Task {
	private String taskID;
	private String taskName;
	private String taskDescription;
	
	// Constructor
	public Task(String taskID, String taskName, String taskDescription) {
		if (taskID == null || taskID.length() > 10 ) {
			throw new IllegalArgumentException("ID must be less than or equal to 10 characters and not null.");
		}
		
		else {
			this.taskID = taskID;
			
			setTaskName(taskName);
			setTaskDescription(taskDescription);
		}
	}
	
	// Getters and Setters
	public String getTaskID() {
		return taskID;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public void setTaskName (String taskName) {
		if (taskName != null && taskName.length() <= 20) {
			this.taskName = taskName;
		}
		
		else {
			throw new IllegalArgumentException("Task name cannot be null or greater than 20 characters.");
		}
	}
	
	public String getTaskDescription() {
		return taskDescription;
	}
	
	public void setTaskDescription(String taskDescription) {
		if (taskDescription == null || taskDescription.length() > 50) {
			this.taskDescription = taskDescription;
		}
		
		else {
			throw new IllegalArgumentException("Task description cannot be null or greater than 50 characters.");
		}
	}
	
	
	// toString method
	@Override
	public String toString() {
		return "Task{" + "ID='" + taskID + '\'' +
				", taskName='" + taskName + '\'' +
				", taskDescription='" + taskDescription + '\'' +
				'}';
	}
}