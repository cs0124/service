package com.dtelec.icmes.workflow.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dtelec.icmes.workflow.service.IProcessService;

@RestController
public class processController {

	@Autowired
	private  IProcessService processServiceImpl;

	
	@RequestMapping("/deployProcessDefinition")
	public String deployProcess() {
		return processServiceImpl.deployProcess();
	}
	
	
	@RequestMapping(value="/startProcessDefinition/{processDefinitionKey}")
	public String startProcessByDefinitionKey(@PathVariable("processDefinitionKey") String processDefinitionKey) {
		Map<String, Object> map = new HashMap<>();
		return processServiceImpl.startProcessByDefinitionKey(processDefinitionKey, map);
	}
	
	
	@RequestMapping("/processDefinition")
	public List<Map<String, Object>> getAllProcessDefinitions() {
		return processServiceImpl.getAllProcessDefinitions();
	}
	
	
	@RequestMapping(value="/processDefinition/{processDefinitionKey}")
	public List<Map<String, Object>> getProcessDefinitionByKey(@PathVariable("processDefinitionKey") String processDefinitionKey) {
		return processServiceImpl.getProcessDefinitionByKey(processDefinitionKey);
	}
	
	
	@RequestMapping(value="/processInstance")
	public List<Map<String, Object>> getAllProcessInstances() {
		return processServiceImpl.getAllProcessInstances();
	}
	
	
	@RequestMapping(path="/processInstance/{processInstanceId}", method = RequestMethod.GET)
	public Map<String, Object> getProcessInstanceById(@PathVariable("processInstanceId") String processInstanceId) {
		return processServiceImpl.getProcessInstanceById(processInstanceId);
	}
	
	
	@RequestMapping(path = "/processInstance/{processInstanceId}", method = RequestMethod.DELETE)
	public String removeProcessInstanceById(@PathVariable("processInstanceId") String processInstanceId) {
		return processServiceImpl.removeProcessInstanceById(processInstanceId);
	}
	
	
	@RequestMapping(path = "/processInstance/{processInstanceId}/status")
	public String getProcessInstanceStatusById(@PathVariable("processInstanceId") String processInstanceId) {
		return processServiceImpl.getProcessInstanceStatusById(processInstanceId);
	}
	
}
