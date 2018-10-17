package com.dtelec.icmes.workflow.service;

import java.util.List;
import java.util.Map;

public interface IProcessService {
	String deployProcess();
	
	String startProcessByDefinitionKey(String processDefinitionKey, Map<String, Object> processVariables);
	
	List<Map<String, Object>> getAllProcessDefinitions();
	
	List<Map<String, Object>> getProcessDefinitionByKey(String processDefinitionKey);
	
	List<Map<String, Object>> getAllProcessInstances();
	
	Map<String, Object> getProcessInstanceById(String processInstanceId);
	
	String removeProcessInstanceById(String processInstanceId);
	
	String getProcessInstanceStatusById(String processInstanceId);
}
