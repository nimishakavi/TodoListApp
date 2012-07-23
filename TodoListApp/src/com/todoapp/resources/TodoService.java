package com.todoapp.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.todoapp.model.Todo;
import com.todoapp.util.TodoAppUtil;

@Path("TodoService")
public class TodoService {

	@GET 
	@Path("/listTodo/{userId}")  
	@Produces("text/plain")
	/**
	 * This service will list the tasks for the given user
	 * 
	 * @param userId
	 * @return
	 */
	public String listTodo(@PathParam("userId")String userId){	
		//TodoAppUtil.initTodoList(userId);
		return TodoAppUtil.listTodos(userId);      
	}
	
	@GET 
	@Path("/listTodoXML/{userId}")  
	@Produces("application/xml")
	/**
	 * This service lists the tasks in XML format
	 * 
	 * @param userId
	 * @return
	 */
	public Todo listTodoXML(@PathParam("userId")String userId){	
		return TodoAppUtil.listTodosXML(userId);      
	}
	
	@GET 
	@Path("/deleteTodo/{userId}/{taskSeqNum}")  
	@Produces("text/plain")
	/**
	 * This service deletes specified task for the given user
	 * 
	 * @param userId
	 * @param taskSeqNum
	 * @return
	 */
	public String deleteTodo(@PathParam("userId")String userId, @PathParam("taskSeqNum")int taskSeqNum){	
		TodoAppUtil.deleteTask(userId, taskSeqNum);
		return TodoAppUtil.listTodos(userId);      
	}
	
	@GET 
	@Path("/createTodo")  
	@Produces("text/plain")
	// Sample Uri:http://localhost:8080/TodoApp/resources/TodoService/createTodo?userId=Nimish&title= title&taskDescription=Desc-1&taskDueDate=Date1&taskStatus=Completed&taskDescription=Desc-2&taskDueDate=Date2&taskStatus=In Progress&&taskDescription=Desc-3&taskDueDate=Date3&taskStatus=Not Started
	/**
	 * This service creates the todo list for the given user
	 * 
	 * @param userId
	 * @param title
	 * @param taskDescription
	 * @param taskDueDate
	 * @param taskStatus
	 * @return
	 */
	public String createTodoList(
			@QueryParam("userId") String userId, 
			@QueryParam("title") String  title, 
			@QueryParam("taskDescription") List<String> taskDescription, 
			@QueryParam("taskDueDate") List<String> taskDueDate,
			@QueryParam("taskStatus") List<String> taskStatus) {
	
		TodoAppUtil.createTodoList(userId, title, taskDescription, taskDueDate, taskStatus);
		return TodoAppUtil.listTodos(userId);
		
	}
	
	@GET 
	@Path("/addTodo")  
	@Produces("text/plain")
	// Sample Uri:http://localhost:8080/TodoApp/resources/TodoService/createTodo?userId=Nimish&title= title&taskDescription=Desc-1&taskDueDate=Date1&taskStatus=Completed&taskDescription=Desc-2&taskDueDate=Date2&taskStatus=In Progress&&taskDescription=Desc-3&taskDueDate=Date3&taskStatus=Not Started
	/**
	 * This service creates the todo list for the given user
	 * 
	 * @param userId
	 * @param title
	 * @param taskDescription
	 * @param taskDueDate
	 * @param taskStatus
	 * @return
	 */
	public String addTodoList(
			@QueryParam("userId") String userId, 
			@QueryParam("title") String  title, 
			@QueryParam("taskDescription") List<String> taskDescription, 
			@QueryParam("taskDueDate") List<String> taskDueDate,
			@QueryParam("taskStatus") List<String> taskStatus) {
	
		TodoAppUtil.addTodoList(userId, title, taskDescription, taskDueDate, taskStatus);
		return TodoAppUtil.listTodos(userId);
		
	}
	
	@GET 
	@Path("/updateTodo")  
	@Produces("text/plain")
	/**
	 * This service updates the todo list for the given user
	 * 
	 * @param userId
	 * @param title
	 * @param taskSeqNum
	 * @param taskDescription
	 * @param taskDueDate
	 * @param taskStatus
	 * @return
	 */
	public String updateTodoList(
			@QueryParam("userId") String userId, 
			@QueryParam("title") String  title,
			@QueryParam("taskSeqNum") int taskSeqNum,
			@QueryParam("taskDescription") String taskDescription, 
			@QueryParam("taskDueDate") String taskDueDate,
			@QueryParam("taskStatus") String taskStatus) {
	
		TodoAppUtil.updateTodoList(userId, title, taskSeqNum, taskDescription, taskDueDate, taskStatus);
		return TodoAppUtil.listTodos(userId);
		
	}
	
	/*


http://localhost:8080/TodoApp/resources/TodoService/createTodo?userId=Devi&title= title&taskDescription=Desc-1&taskDueDate=Date1&taskStatus=Completed&taskDescription=Desc-2&taskDueDate=Date2&taskStatus=In Progress&&taskDescription=Desc-3&taskDueDate=Date3&taskStatus=Not Started&taskDescription=Desc-4&taskDueDate=Date3&taskStatus=Not Started&taskDescription=Desc-5&taskDueDate=Date3&taskStatus=Not Started&taskDescription=Desc-6&taskDueDate=Date3&taskStatus=Not Started 
	 */

}
