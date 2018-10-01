package com.dtelec.icmes.common.error;

public class IcmesException extends Exception {

	private static final long serialVersionUID = 8232022286346253844L;

    private int errorCode;
    protected int errorType;
    
    
    public IcmesException(IcmesErrorTypeEnum errorType, String message) {
    	super((message == null) ? errorType.getErrorDesc() : message);
    	this.errorCode = errorType.getErrorCode();
    	this.errorType = 0;
    }


	public int getErrorCode() {
		return errorCode;
	}

	public int getErrorType() {
		return errorType;
	}	
	
}
