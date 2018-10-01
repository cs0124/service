package com.dtelec.icmes.information.service.model;

import java.util.ArrayList;
import java.util.List;

import com.dtelec.icmes.information.repository.entity.DictEntity;

public class DictCollection {
	
	private List<DictModel> list;
	
	public DictCollection() {
		this.list = new ArrayList<>();
	}
	
	public void fill(List<DictEntity> entities) {
		if (entities != null) {
			for (DictEntity entity : entities) {
				DictModel model = new DictModel();
				model.fill(entity);
				this.list.add(model);
			}
		}
	}

	public List<DictModel> getList() {
		return list;
	}

}
