package com.todoapp.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Nimishakavi
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Todo {

	
	public String userId;
	//public String todoDescription;
	public String todoTitle;
	public List<Task> tasks;
	//@XmlElement
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	//@XmlElement
	public String getTodoTitle() {
		return todoTitle;
	}
	public void setTodoTitle(String todoTitle) {
		this.todoTitle = todoTitle;
	}
	//@XmlElement (name = "TaskList")
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	
}
