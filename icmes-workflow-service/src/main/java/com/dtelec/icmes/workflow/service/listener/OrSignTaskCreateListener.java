package com.dtelec.icmes.workflow.service.listener;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;

public class OrSignTaskCreateListener implements TaskListener {

	private static final long serialVersionUID = 4941990459258322061L;

	@Autowired
	RuntimeService runtimeService;
	
	@Autowired
	TaskService taskService;
	
	@Override
	public void notify(DelegateTask delegateTask) {
		// 或签任务创建时，设置candidate user
		if (delegateTask.getTaskDefinitionKey().compareTo("PROF_DEPT_CHECK") == 0) {
			delegateTask.addCandidateUser("user1");
			delegateTask.addCandidateUser("user2");
		} else if (delegateTask.getTaskDefinitionKey().compareTo("SEC_DEPT_CHECK") == 0) {	
			delegateTask.addCandidateUser("user3");
			delegateTask.addCandidateUser("user4");
		} /*else if (delegateTask.getTaskDefinitionKey().compareTo("WIREMAN_CHECK") == 0) {	
			delegateTask.addCandidateUser("user5");
			delegateTask.addCandidateUser("user6");
		}*/
		
    	delegateTask.setVariableLocal("TaskRole", delegateTask.getTaskDefinitionKey() + "_ROLE");
	}

}
