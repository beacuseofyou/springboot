package com.hzydbs.utils;

/**
 * author: San Jinhong
 * date: 2019/10/12 14:38
 **/

public enum ErrorCode {
	OK("0", "成功");

	public String value;

	public String memo;

	ErrorCode(String value, String memo) {
		this.value = value;
		this.memo = memo;
	}
}
