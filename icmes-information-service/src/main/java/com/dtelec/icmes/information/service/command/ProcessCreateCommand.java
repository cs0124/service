package com.dtelec.icmes.information.service.command;

import com.dtelec.icmes.information.service.model.ProcessModel;

/**
 * 新建工艺模型
 *
 */
public class ProcessCreateCommand implements ICommand<ProcessModel>{

	private ProcessModel model = null;

	public ProcessCreateCommand(ProcessModel model) {
		this.model = model;
	}

	public ProcessModel getModel() {
		return model;
	}

	public void setModel(ProcessModel model) {
		this.model = model;
	}
	
	
	
}

