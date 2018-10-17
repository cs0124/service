package com.dtelec.icmes.workflow.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtelec.icmes.workflow.service.ITaskService;
import com.dtelec.icmes.workflow.service.ITaskService.TaskFinishType;

@RestController
public class taskController {

	@Autowired
	private ITaskService taskServiceImpl;

	
	@RequestMapping("/task")
	public List<Map<String, Object>> taskList() {
		return taskServiceImpl.getAllTasks();
	}
	
	
	@RequestMapping("/task/{taskId}")
	public Map<String, Object> getTaskByTaskId(@PathVariable String taskId) {
		return taskServiceImpl.getTaskByTaskId(taskId);
	}
	
	
	@RequestMapping("/task/{taskId}/complete")
	public String completeTaskById(@PathVariable String taskId) {
		return taskServiceImpl.completeTaskById(taskId, TaskFinishType.NORMAL);
	}
	
	
	@RequestMapping("/task/{taskId}/approve")
	public String approveTaskById(@PathVariable String taskId) {
		return taskServiceImpl.completeTaskById(taskId, TaskFinishType.APPROVE);
	}
	
	
	@RequestMapping("/task/{taskId}/reject")
	public String rejectTaskById(@PathVariable String taskId) {
		return taskServiceImpl.completeTaskById(taskId, TaskFinishType.REJECT);
	}
	
	
	@RequestMapping("/task/{taskId}/history")
	public Map<String, Object> getTaskHistory(@PathVariable String taskId) {
		return taskServiceImpl.getTaskHistoryByTaskId(taskId);
	}
	
	
	@RequestMapping("/task/all/complete")
	public String completeAllTask() {
		return taskServiceImpl.completeAllTask();
	}
	
	
	@RequestMapping("/userTask/{userId}")
	public List<Map<String, Object>> getUserTaskByUserId(@PathVariable String userId) {
		return taskServiceImpl.getUserTaskByUserId(userId);
	}
	
	
	@RequestMapping("/historicTask/")
	public List<Map<String, Object>> getAllHistoricTasks() {
		return taskServiceImpl.getAllHistoricTasks();
	}
	
}
