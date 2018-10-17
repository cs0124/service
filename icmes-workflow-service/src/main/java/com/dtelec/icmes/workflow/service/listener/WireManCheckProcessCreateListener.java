package com.dtelec.icmes.workflow.service.listener;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("serial")
public class WireManCheckProcessCreateListener implements ExecutionListener{

	@Autowired
	RuntimeService runtimeService;
	
	@Autowired
	TaskService taskService;
	
	@Override
	public void notify(DelegateExecution execution) {
		// TODO Auto-generated method stub
		List<String> userList = new ArrayList<>();
		userList.add("user11");
		userList.add("user12");
		userList.add("user13");
		userList.add("user14");
		userList.add("user15");
		execution.setVariable("wiremanList", userList);
		System.out.println(userList.toString());
	}
}
