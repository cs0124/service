package com.dtelec.icmes.workflow.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.FormService;
import org.activiti.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dtelec.icmes.workflow.service.IProcessService;

@Service
public class ProcessServiceImpl implements IProcessService{
	@Autowired
	RuntimeService runtimeService;
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	RepositoryService repositoryService;
	
	@Autowired
	FormService formService;
	
	public enum TaskFinishType {
		// type of complete task 
		 NORMAL, APPROVE, REJECT ;
	}
	
	
	@Override
    @Transactional(rollbackFor = Exception.class)
	public String deployProcess() {
		try {
			// 存储服务部署流程
			repositoryService.createDeployment()
				.addClasspathResource("processes/HV_POWER_CUT.bpmn")
				.addClasspathResource("processes/HV_POWER_CUT.png")
				.addClasspathResource("processes/POWER_DELIVERY.bpmn")
				.addClasspathResource("processes/POWER_DELIVERY.png")
				.addClasspathResource("processes/POWER_DELIVERY_POSTPONE.bpmn")
				.addClasspathResource("processes/POWER_DELIVERY_POSTPONE.png")
				.deploy();
		} catch (Exception e) {
			return e.toString();
		}
		return "Success";
	}
	
	
	@Override
    @Transactional(rollbackFor = Exception.class)
	public String startProcessByDefinitionKey(String processKey, Map<String, Object> processVariables) {
		
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processKey, processVariables);
		
		Task activeTask = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
		taskService.claim(activeTask.getId(), "employee");
		
		return "ProcessId: " + processInstance.getId() + "\n"
				+ " ActiveTaskId: " + activeTask.getId() + "\n"
				+ " was asigned to employee" + "\n\n"
				+ " it require properties: " + formService.getTaskFormData(activeTask.getId()).getFormProperties();
	}
	
	
	@Override
    @Transactional(rollbackFor = Exception.class)
    public List<Map<String, Object>> getAllProcessDefinitions() {
		
		List<Map<String, Object>> processDefinitionList = new ArrayList<>();

        repositoryService.createProcessDefinitionQuery().latestVersion().list().stream()
                .forEach(processDefinition -> {
                    Map<String, Object> map = new HashMap<>();
                    
                    map.put("id", processDefinition.getId());
                    map.put("key", processDefinition.getKey());
                    map.put("name", processDefinition.getName());
                    map.put("deploymentId", processDefinition.getDeploymentId());
                    map.put("tenantId", processDefinition.getTenantId());
                    map.put("version", processDefinition.getVersion());
                    
                    processDefinitionList.add(map);
                });
        
        return processDefinitionList;
	}
	
	
	@Override
    @Transactional(rollbackFor = Exception.class)
    public List<Map<String, Object>> getProcessDefinitionByKey(String processDefinitionKey) {
		
		List<Map<String, Object>> result = new ArrayList<>();

        repositoryService.createProcessDefinitionQuery().processDefinitionKey(processDefinitionKey).list().stream()
			.forEach(processDefinition -> {
				Map<String, Object> map = new HashMap<>();
				
				map.put("id", processDefinition.getId());
		        map.put("key", processDefinition.getKey());
		        map.put("name", processDefinition.getName());
		        map.put("deploymentId", processDefinition.getDeploymentId());
		        map.put("tenantId", processDefinition.getTenantId());
		        map.put("version", processDefinition.getVersion());
		        
		        result.add(map);
			});
        
        return result;
	}
	
	
	@Override
    @Transactional(rollbackFor = Exception.class)
    public List<Map<String, Object>> getAllProcessInstances() {
		
		List<Map<String, Object>> processInstanceList = new ArrayList<>();

        runtimeService.createProcessInstanceQuery().list().stream()
                .forEach(activeProcessInstance -> {
                    Map<String, Object> map = new HashMap<>();
                    
                    map.put("id", activeProcessInstance.getId());
                    map.put("definition name", activeProcessInstance.getProcessDefinitionName());
                    map.put("definition version", activeProcessInstance.getProcessDefinitionVersion());
                    map.put("deploymentId", activeProcessInstance.getDeploymentId());
               		map.put("start time", activeProcessInstance.getStartTime().toString());
               		map.put("process definition version", activeProcessInstance.getProcessDefinitionVersion());
               		map.put("process variables", activeProcessInstance.getProcessVariables());
               		
               		processInstanceList.add(map);
                });
        
        return processInstanceList;
	}
	
	
	@Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> getProcessInstanceById(String processInstanceId) {
		
		Map<String, Object> result = new HashMap<>();

        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
        									.processInstanceId(processInstanceId).singleResult();
        if (processInstance != null) {
            result.put("id", processInstance.getId());
            result.put("name", processInstance.getName());
            result.put("deploymentId", processInstance.getDeploymentId());
            result.put("tenantId", processInstance.getTenantId());
       		result.put("start time", processInstance.getStartTime().toString());
       		result.put("process definition version", processInstance.getProcessDefinitionVersion());
       		result.put("process variables", processInstance.getProcessVariables());
       		
       		Map<String, Object> processVar = runtimeService.getVariables(processInstance.getId());
       		System.out.println(processVar.size());
       		for (String key : processVar.keySet()) {
				result.put(key, processVar.get(key));
			}
       		
            return result;
		} else {
			Execution execution = runtimeService.createExecutionQuery().executionId(processInstanceId).singleResult();
			
			result.put("id", execution.getId());
            result.put("name", execution.getName());
            result.put("activityId", execution.getActivityId());
            result.put("tenantId", execution.getTenantId());
            
			return result;
		}

	}
	
	
	@Override
    @Transactional(rollbackFor = Exception.class)
    public String removeProcessInstanceById(String processInstanceId) {
		try {
			runtimeService.deleteProcessInstance(processInstanceId, "testing");
			return "success to delete process instance id: " + processInstanceId.toString();
		}
        catch(Exception e) {
        	return e.toString();
        }
	}
	
	
	@Override
    @Transactional(rollbackFor = Exception.class)
    public String getProcessInstanceStatusById(String processInstanceId) {
		try {
			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
					.processInstanceId(processInstanceId).singleResult();

			return "process status: " + processInstance.isEnded();
		}
        catch(Exception e) {
        	return e.toString();
        }
	}
}
