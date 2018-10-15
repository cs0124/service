package com.dtelec.icmes.information.service.command;

import com.dtelec.icmes.information.service.model.DeviceCategoryModel;

/**
 * 设备类型新建command
 * @author schi
 *
 */
public class DeviceCategoryCreateCommand implements ICommand<Void> {

	private DeviceCategoryModel model;
	private int[] relatedSpceDataIds;
	
    public DeviceCategoryCreateCommand(DeviceCategoryModel model) {
        this.model = model;
    }

	public DeviceCategoryModel getModel() {
		return model;
	}

	public void setModel(DeviceCategoryModel model) {
		this.model = model;
	}

	public int[] getRelatedSpceDataIds() {
		return relatedSpceDataIds;
	}

	public void setRelatedSpceDataIds(int[] relatedSpceDataIds) {
		this.relatedSpceDataIds = relatedSpceDataIds;
	}
    	
}
