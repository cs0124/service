package com.dtelec.icmes.workflow.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.workflow.service.ITaskService;

/**
 * @author Shaoyi Chen
 */

@Service
public class TaskServiceImpl implements ITaskService{
	
	/* auto injection area of activiti service api */
	@Autowired
	TaskService taskService;
	
	@Autowired
	FormService formService;
	
	@Autowired
	RuntimeService runtimeService;
	
	@Autowired
	HistoryService historyService;
	
	// return all active tasks
	public List<Map<String, Object>> getAllTasks() {
		
		List<Task> activeTasks = taskService.createTaskQuery().list();

		List<Map<String, Object>> taskList = new ArrayList<>();
		
		activeTasks.stream().forEach(t -> {
			Map<String, Object> map = new HashMap<>();
            map.put("id", t.getId());
            map.put("task_name", t.getName());
            map.put("pro_inst_id", t.getProcessInstanceId());
            map.put("pro_def_id", t.getProcessDefinitionId());
            map.put("task_def_key",t.getTaskDefinitionKey());
            map.put("task_owner", t.getOwner());
            map.put("executionId", t.getExecutionId());
            map.put("local variables", t.getTaskLocalVariables());
            map.put("asignee", t.getAssignee());
            taskList.add(map);
		});
		return taskList;
	}
	
	
	// return one task by taskId
	public Map<String, Object> getTaskByTaskId(String taskId) {

		Task t = taskService.createTaskQuery().taskId(taskId).singleResult();
			if (t != null) {
				Map<String, Object> map = new HashMap<>();
				
				map.put("id", t.getId());
	            map.put("pro_inst_id", t.getProcessInstanceId());
	            map.put("pro_def_id", t.getProcessDefinitionId());
	            map.put("task_def_key",t.getTaskDefinitionKey());
	            map.put("task_owner", t.getOwner());
	            map.put("executionId", t.getExecutionId());
	            map.put("local variables", t.getTaskLocalVariables());
	            map.put("asignee", t.getAssignee());

				return map;
			} 

			HistoricTaskInstance taskInstance = historyService.createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
			if (taskInstance != null) {
				Map<String, Object> map = new HashMap<>();
				
				map.put("id", taskInstance.getId());
	            map.put("pro_inst_id", taskInstance.getProcessInstanceId());
	            map.put("pro_def_id", taskInstance.getProcessDefinitionId());
	            map.put("task_def_key",taskInstance.getTaskDefinitionKey());
	            map.put("task_owner", taskInstance.getOwner());
	            map.put("executionId", taskInstance.getExecutionId());
	            map.put("local variables", taskInstance.getTaskLocalVariables());
	            map.put("asignee", taskInstance.getAssignee());
	            map.put("task finished", true);
	            
				return map;
			}
		return null;
	}
	
	
	// return one history task by taskId
	public Map<String, Object> getTaskHistoryByTaskId(String taskId) {
		HistoricTaskInstance t = historyService.createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
		if (t != null) {
			Map<String, Object> map = new HashMap<>();
			
			map.put("id", t.getId());
            map.put("pro_inst_id", t.getProcessInstanceId());
            map.put("pro_def_id", t.getProcessDefinitionId());
            map.put("task_def_key",t.getTaskDefinitionKey());
            map.put("task_owner", t.getAssignee());
            
			return map;
		} else {
			Map<String, Object> result = new HashMap<>();
			result.put("key", "not found");
			return result;
		}
	}
	
	
	// approve one task by taskId
	public String completeTaskById(String taskId, TaskFinishType taskFinishType) {
		Task t = taskService.createTaskQuery().taskId(taskId).singleResult();
		
		Map<String, Object> variables = new HashMap<>();
		
		if (taskFinishType.equals(TaskFinishType.APPROVE)) {
			variables.put(t.getTaskDefinitionKey() + "_APPROVE", true);
		} else if (taskFinishType.equals(TaskFinishType.REJECT)) {
			variables.put(t.getTaskDefinitionKey() + "_APPROVE", false);
		}
		
		if (t != null) {
			//sub process
			if (chkTaskBelongToSubprocess(taskId)) {
				Execution parentExecution = runtimeService.createExecutionQuery().executionId(getParentExecutionIdByTaskId(taskId)).singleResult();
				if (taskFinishType.equals(TaskFinishType.APPROVE)) {
					variables.put(parentExecution.getActivityId() + "_APPROVE", true);
				} else if (taskFinishType.equals(TaskFinishType.REJECT)) {
					variables.put(parentExecution.getActivityId() + "_APPROVE", false);
				}
				
				runtimeService.setVariables(parentExecution.getId(), variables);
			}
			
			taskService.complete(t.getId(), variables);
			return "Success to approve task: " + t.getTaskDefinitionKey();
		} 
		return "Not Found";
	}
	
	
	// check if the task belong to a subprocess
	boolean chkTaskBelongToSubprocess(String taskId) {
		Task t = taskService.createTaskQuery().taskId(taskId).singleResult();
		Execution execution = runtimeService.createExecutionQuery().executionId(t.getExecutionId()).singleResult();
		if (execution.getProcessInstanceId().compareTo(execution.getParentId()) != 0) {
			return true;
		}
		return false;
	}
	
	
	// return parent executionId of the subprocess which the task belong to
	String getParentExecutionIdByTaskId(String taskId) {
		Task t = taskService.createTaskQuery().taskId(taskId).singleResult();
		Execution execution = runtimeService.createExecutionQuery().executionId(t.getExecutionId()).singleResult();
		return execution.getParentId();
	}

	
	// will be removed
	public String completeAllTask() {
		List<Task> tasks = taskService.createTaskQuery().list();
		while(tasks != null && tasks.size() > 0) {
			try {
				taskService.createTaskQuery().list().forEach(task -> {
					taskService.complete(task.getId());
				});
			}
			catch(Exception e) {
				return "Error Found";
			}
			tasks = taskService.createTaskQuery().list();
		}
		return "Success";
	}
	
	
	// return one task by taskId
	public List<Map<String, Object>> getUserTaskByUserId(String userId) {
		List<Task> activeTasks = taskService.createTaskQuery().taskCandidateOrAssigned(userId).list();

		List<Map<String, Object>> taskList = new ArrayList<>();
		
		activeTasks.stream().forEach(t -> {
			Map<String, Object> map = new HashMap<>();
            map.put("id", t.getId());
            map.put("task_name", t.getName());
            map.put("pro_inst_id", t.getProcessInstanceId());
            map.put("pro_def_id", t.getProcessDefinitionId());
            map.put("task_def_key",t.getTaskDefinitionKey());
            map.put("task_owner", t.getOwner());
            map.put("executionId", t.getExecutionId());
            map.put("local variables", t.getTaskLocalVariables());
            map.put("asignee", t.getAssignee());
            
            taskList.add(map);
		});
		return taskList;
	}
	
	
	//get all history task
	public List<Map<String, Object>> getAllHistoricTasks() {
		List<HistoricTaskInstance> historicTasks = historyService.createHistoricTaskInstanceQuery().list();

		List<Map<String, Object>> taskList = new ArrayList<>();
		
		historicTasks.stream().forEach(t -> {
			Map<String, Object> map = new HashMap<>();
			
            map.put("id", t.getId());
            map.put("task_name", t.getName());
            map.put("pro_inst_id", t.getProcessInstanceId());
            map.put("pro_def_id", t.getProcessDefinitionId());
            map.put("task_def_key",t.getTaskDefinitionKey());
            map.put("task_owner", t.getOwner());
            map.put("executionId", t.getExecutionId());
            map.put("local variables", t.getTaskLocalVariables());
            map.put("asignee", t.getAssignee());
            
            taskList.add(map);
		});
		return taskList;
	}
}
