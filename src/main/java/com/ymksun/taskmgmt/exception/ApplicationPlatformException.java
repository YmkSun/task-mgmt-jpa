package com.ymksun.taskmgmt.exception;

@SuppressWarnings("serial")
public abstract class ApplicationPlatformException extends RuntimeException {
	
	private String errMessage;

	public ApplicationPlatformException(String errMessage) {
		super(errMessage);
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

}
