package com.hzydbs.utils;

/**
 * author: San Jinhong
 * date: 2019/10/12 15:11
 **/
public class CustomException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private ErrorCode errorCode;

	public CustomException(String msg) {
		super(msg);
	}

	public CustomException(String msg, Throwable e) {
		super(msg, e);
	}

	public CustomException(ErrorCode errorCode) {
		super(errorCode.memo);
		this.errorCode = errorCode;
	}

	public CustomException(ErrorCode errorCode,String msg) {
		super(errorCode.memo + ":"+msg);
		this.errorCode = errorCode;
	}
}
