package com.todoapp.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 
 * @author Nimishakavi
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Task {	
	
	//public String taskId;
	public String taskDescripton;	
	public String dueDate;
	public String status;
	
	/*public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}*/
	//@XmlElement
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	//@XmlElement
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	//@XmlElement
	public String getTaskDescripton() {
		return taskDescripton;
	}
	public void setTaskDescripton(String taskDescripton) {
		this.taskDescripton = taskDescripton;
	}

}
