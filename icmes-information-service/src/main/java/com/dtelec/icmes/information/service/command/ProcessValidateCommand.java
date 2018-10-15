package com.dtelec.icmes.information.service.command;

import com.dtelec.icmes.information.service.model.ProcessModel;

/**
 * 工艺验证command
 *
 */
public class ProcessValidateCommand implements ICommand<ProcessModel>{
	ProcessModel model = null;

	public ProcessValidateCommand(ProcessModel model) {
		this.model = model;
	}

	public ProcessModel getModel() {
		return model;
	}

	public void setModel(ProcessModel model) {
		this.model = model;
	}
	
	
	
}
