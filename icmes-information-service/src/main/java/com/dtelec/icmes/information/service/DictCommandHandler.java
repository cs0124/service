package com.dtelec.icmes.information.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.information.repository.IDictRepository;
import com.dtelec.icmes.information.service.annotation.CommandAction;
import com.dtelec.icmes.information.service.command.DictDataCreateCommand;
import com.dtelec.icmes.information.service.command.DictDataDeleteCommand;
import com.dtelec.icmes.information.service.command.DictDataUpdateCommand;
import com.dtelec.icmes.information.service.command.DictTypeCreateCommand;
import com.dtelec.icmes.information.service.command.DictTypeDeleteCommand;
import com.dtelec.icmes.information.service.command.DictTypeUpdateCommand;
import com.dtelec.icmes.information.service.core.ICommandHandler;

@Service
public class DictCommandHandler  implements ICommandHandler  {

	@Autowired
	private IDictRepository repository;
	@CommandAction
	public void addDictType(DictTypeCreateCommand command) throws Exception {
		//调用持久层
		repository.addDictType(command.convert());
		
	}

	
	@CommandAction
	public void updateDictType(DictTypeUpdateCommand command) throws Exception {
	
		//调用持久层
		repository.updateDictType(command.convert());
	}
	

	@CommandAction
	public void addDictData(DictDataCreateCommand command) throws Exception {
		//调用持久层
		repository.addDictData(command.convert());
		
	}	
	
	@CommandAction
	public void updateDictData(DictDataUpdateCommand command) throws Exception {
		//调用持久层
		repository.updateDictData(command.convert());
		
	}
	
	
	
	@CommandAction
	public void deleteDictType(DictTypeDeleteCommand command) throws Exception {
		//调用持久层
		repository.delDictType(command.getCode());
		
	}
	
	
	@CommandAction
	public void deleteDictData(DictDataDeleteCommand command) throws Exception {
		//调用持久层
		repository.delDictData(command.getCode());
		
	}

}
