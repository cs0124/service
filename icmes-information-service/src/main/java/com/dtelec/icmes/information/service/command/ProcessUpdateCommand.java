package com.dtelec.icmes.information.service.command;

import com.dtelec.icmes.information.service.model.ProcessModel;

/**
 * 编辑工艺command
 *
 */
public class ProcessUpdateCommand implements ICommand<ProcessModel>{
	private ProcessModel model = null;
	
	public ProcessUpdateCommand(ProcessModel model) {
		this.model = model;
	}
	public ProcessModel getModel() {
		return model;
	}
	public void setModel(ProcessModel model) {
		this.model = model;
	}
	
}
