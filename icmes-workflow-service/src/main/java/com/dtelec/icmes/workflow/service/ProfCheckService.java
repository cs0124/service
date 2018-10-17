package com.dtelec.icmes.workflow.service;


import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;


public class ProfCheckService  implements JavaDelegate{
	@Autowired
	TaskService taskService;
	
	@Override
	public void execute(DelegateExecution execution) {
		// TODO Auto-generated method stub
		String taskName=execution.getCurrentActivityId();
		 taskName = taskName.replace("_SERVICE", "_APPROVE");	 		
		System.out.println(execution.getVariable(taskName));
		
	}

}
