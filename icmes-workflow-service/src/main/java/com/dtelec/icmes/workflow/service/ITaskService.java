package com.dtelec.icmes.workflow.service;

import java.util.List;
import java.util.Map;

public interface ITaskService {
	
	public enum TaskFinishType {
		// type of complete task 
		 NORMAL, APPROVE, REJECT ;
	}
	
	List<Map<String, Object>> getAllTasks();
	
	Map<String, Object> getTaskByTaskId(String taskId);
	
	Map<String, Object> getTaskHistoryByTaskId(String taskId);
	
	String completeTaskById(String taskId, TaskFinishType taskFinishType);
	
	String completeAllTask();
	
	List<Map<String, Object>> getUserTaskByUserId(String userId);
	
	List<Map<String, Object>> getAllHistoricTasks();
}
