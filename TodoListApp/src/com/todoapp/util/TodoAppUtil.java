package com.todoapp.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.todoapp.model.Task;
import com.todoapp.model.Todo;

public class TodoAppUtil {
	
	// This static object maintains the users tasks
	private static HashMap<String, Todo> todoHashMap = new HashMap<String, Todo>();
	
	/**
	 * This method initializes the data
	 * @param userId
	 * @param title
	 * @param taskDescription
	 * @param taskDueDate
	 * @param taskStatus
	 */
	/*public static void initTodoList(String userId) {
		
		Todo todoObj = new Todo();
		todoObj.setUserId(userId);
		todoObj.setTodoTitle("Just some title...");
		
		List<Task> taskList = new ArrayList<Task>();
		
		Task taskObj1 = new Task();
		taskObj1.setDueDate("2012-07-22");
		taskObj1.setStatus("In progress");
		taskObj1.setTaskDescripton("Task 1 Description");
		
		Task taskObj2 = new Task();
		taskObj1.setDueDate("2012-07-22");
		taskObj2.setStatus("Completed");
		taskObj2.setTaskDescripton("Task 2 Description");
		
		Task taskObj3 = new Task();
		taskObj1.setDueDate("2012-07-22");
		taskObj3.setStatus("Not Started");
		taskObj3.setTaskDescripton("Task 3 Description");
		
		taskList.add(taskObj1);
		taskList.add(taskObj2);
		taskList.add(taskObj3);
		
		todoObj.setTasks(taskList);
		todoHashMap.put(userId, todoObj);
		System.out.println("Todo list for "+ userId +" is initialized");
	}*/
	
	/**
	 * This method creates the todo list for the specified user
	 * 
	 * @param userId
	 * @param title
	 * @param taskDescription
	 * @param taskDueDate
	 * @param taskStatus
	 */
	public static void createTodoList(
			String userId,  String  title, 
			List<String> taskDescription, List<String> taskDueDate,
			List<String> taskStatus) {
		
		if (taskDescription.size() == taskDueDate.size() && taskDueDate.size() == taskStatus.size()) {
			Todo todoObj = new Todo();
			todoObj.setUserId(userId);
			todoObj.setTodoTitle(title);
			
			List<Task> taskList = new ArrayList<Task>();
			Task taskObj = null;
			for (int i=0; i<taskDescription.size(); i++) {
				
				taskObj = new Task();
				taskObj.setDueDate(taskDueDate.get(i));
				taskObj.setStatus(taskStatus.get(i));
				taskObj.setTaskDescripton(taskDescription.get(i));
				taskList.add(taskObj);
				
			}
			todoObj.setTasks(taskList);
			todoHashMap.put(userId, todoObj);			
		} else {
			System.out.println("Some Error in URI");
		}
		
	}
	
	/**
	 * This method adds tasks to the todo list for the specified user
	 * 
	 * @param userId
	 * @param title
	 * @param taskDescription
	 * @param taskDueDate
	 * @param taskStatus
	 */
	public static void addTodoList(
			String userId,  String  title, 
			List<String> taskDescription, List<String> taskDueDate,
			List<String> taskStatus) {
		
		Todo todoObj = todoHashMap.get(userId);
		
		if(todoObj == null) {
			createTodoList(userId, title, taskDescription, taskDueDate, taskStatus);
		} else {		
			if (taskDescription.size() == taskDueDate.size() && taskDueDate.size() == taskStatus.size()) {
				todoObj.setUserId(userId);
				todoObj.setTodoTitle(title);
				
				List<Task> taskList = todoObj.getTasks();
				Task taskObj = null;
				for (int i=0; i<taskDescription.size(); i++) {
					
					taskObj = new Task();
					taskObj.setDueDate(taskDueDate.get(i));
					taskObj.setStatus(taskStatus.get(i));
					taskObj.setTaskDescripton(taskDescription.get(i));
					taskList.add(taskObj);
					
				}
				todoObj.setTasks(taskList);
				todoHashMap.put(userId, todoObj);			
			}
		}		
	}
	
	/**
	 * This method updates the tasks for the existing user
	 * 
	 * @param userId
	 * @param title
	 * @param taskSeqNum
	 * @param taskDescription
	 * @param taskDueDate
	 * @param taskStatus
	 */
	public static void updateTodoList (
			String userId, String title, int taskSeqNum, 
			String taskDescription,	String taskDueDate, String taskStatus) {
		Todo todoObj = todoHashMap.get(userId);	
		if(null != todoObj) {
			
			List<Task> taskList = todoObj.getTasks();
			taskList.remove(taskSeqNum);
			
			Task taskObj = new Task();			
			taskObj.setDueDate(taskDueDate);			
			taskObj.setTaskDescripton(taskDescription);
			taskObj.setStatus(taskStatus);			
			taskList.add(taskSeqNum, taskObj);			
			todoObj.setTasks(taskList);
			
			todoHashMap.put(userId, todoObj);
		}		
	}
	
	/**
	 * This method lists the tasks for the given user
	 * 
	 * @param userId
	 * @return
	 */
	public static String listTodos(String userId) {
			return iterateUserTasks(userId);
	}
	
	/**
	 * This method lists the tasks in XML formatting
	 * 
	 * @param userId
	 * @return
	 */
	
	public static Todo listTodosXML(String userId) {
		return todoHashMap.get(userId);
	}
	
	/**
	 * This method iterates the tasks for a given user
	 * 
	 * @param userId
	 * @return
	 */
	private static String iterateUserTasks(String userId) {
		StringBuffer tasksBuffer = new StringBuffer();
		
		Todo todoObj = todoHashMap.get(userId);
		
		if(null != todoObj) {
		
			tasksBuffer.append("\nTasks for "+ userId + "\n");
			tasksBuffer.append("Todo Title: " + todoObj.getTodoTitle()+"\n");
			List<Task> taskList = todoObj.getTasks();
			tasksBuffer.append("------------------------\n");
			Iterator<Task> itr = taskList.iterator();
			while (itr.hasNext()) {
				Task taskObj = (Task) itr.next();
				tasksBuffer.append("Task Description: " + taskObj.getTaskDescripton()+"\n");
				tasksBuffer.append("Due Date: " + taskObj.getDueDate()+"\n");
				tasksBuffer.append("Task Status: " + taskObj.getStatus()+"\n");
				tasksBuffer.append("------------------------\n");
				
			}
		} else {
			tasksBuffer.append(userId + " has No Tasks");
		}
		
		return tasksBuffer.toString();
	}
	
	/**
	 * This method deletes the task at the specified location for the given user
	 * 
	 * @param userId
	 * @param taskSeqNum
	 */
	public static void deleteTask(String userId, int taskSeqNum) {
		Todo todoObj = todoHashMap.get(userId);	
		List<Task> taskList = null;
		if(null != todoObj) {
			taskList = todoObj.getTasks();
			taskList.remove(taskSeqNum);			
			System.out.println("List count = " + taskList.size());
			todoObj.setTasks(taskList);
		}		
		todoHashMap.put(userId, todoObj);		
	}
	
	public static void updateTask(String user, Task taskObj) {
		
	}
}
