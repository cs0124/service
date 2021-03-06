package com.dtelec.icmes.information.service.command;

import com.dtelec.icmes.information.service.model.DeviceValueModel;

/**
 * 设备净值 Create command
 * 作者：孔轩
 */
public class DeviceValueCreateCommand implements ICommand<DeviceValueModel> {
    /**
     * 设备哦净值Model
     */
    private DeviceValueModel model;

    public DeviceValueCreateCommand(DeviceValueModel model) {
        this.model = model;
    }

    public DeviceValueModel getModel() {
        return model;
    }

    public void setModel(DeviceValueModel model) {
        this.model = model;
    }
}