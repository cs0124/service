package com.dtelec.icmes.common.error;

public class IcmesBusinessException extends IcmesException {

	private static final long serialVersionUID = 6128618551574215350L;

	public IcmesBusinessException(IcmesErrorTypeEnum errorType, String message) {
		super(errorType, message);
		this.errorType = 1;
	}

}
