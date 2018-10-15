package com.dtelec.icmes.common.error;

/**
 * 系统中业务逻辑异常的错误类
 * @author hlxu
 *
 */
public class IcmesBusinessException extends IcmesException {

	private static final long serialVersionUID = 6128618551574215350L;

	public IcmesBusinessException(IcmesErrorTypeEnum errorType, String message) {
		super(errorType, message);
		this.errorType = 1;
	}
	
	public IcmesBusinessException(IcmesErrorTypeEnum errorType) {
		this(errorType, null);
	}

}
