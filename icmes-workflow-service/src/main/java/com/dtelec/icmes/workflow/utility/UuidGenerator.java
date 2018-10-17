package com.dtelec.icmes.workflow.utility;

import java.util.UUID;

import org.activiti.engine.impl.cfg.IdGenerator;
import org.springframework.stereotype.Component;

@Component 
public class UuidGenerator implements IdGenerator { 
	@Override 
	public String getNextId() { 
		return UUID.randomUUID().toString().replaceAll("-", ""); 
	} 
}