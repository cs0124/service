package com.dtelec.icmes.information.service.query;

import com.dtelec.icmes.information.service.model.ProcessModel;

/**
 * 工艺查询Query
 *
 */
public class ProcessDetailQuery implements IQuery<ProcessModel>{
	
	private int id;
	
	public ProcessDetailQuery(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
