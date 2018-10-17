package com.dtelec.icmes.workflow.service.impl;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class TestServiceTask implements JavaDelegate{
	
	@Override
	public void execute(DelegateExecution execution) {
		String taskName = execution.getCurrentActivityId();
		String variableName = taskName.replace("SERVICETASK", "APPROVE");
		System.out.println(execution.getVariable(variableName));
		System.out.println("serviceTask complete！");
	}
}
