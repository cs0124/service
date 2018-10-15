package com.dtelec.icmes.information.service.command;

import com.dtelec.icmes.information.service.model.ProcessModel;

/**
 * 工艺删除command
 *
 */
public class ProcessDeleteCommand implements ICommand<ProcessModel>{
	
	private int id;
	
	public ProcessDeleteCommand(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}	
	
}
