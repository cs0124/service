package com.dtelec.icmes.power.controller.vo;

import java.util.List;

public class ResUploadTicketPhotoVO {

	public List<TicketFileVO> ticketFiles;
	
	public static class TicketFileVO {
		public String name;
		public String fileId;
	}
	
}
