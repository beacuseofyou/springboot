package com.hzydbs.response;

import lombok.Data;

/**
 * author: San Jinhong
 * date: 2019/10/12 14:37
 **/
@Data
public class Response {

	private String errorCode;

	private String value;

	private Object data;


}
