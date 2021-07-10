/**
 * 
 */
package com.abc.simplehouse.exceptions;

import org.springframework.stereotype.Component;

/**
 * @author brahmareddy
 * 05-Jul-2021
 */
@Component
public class ErrorResponse {
	
	private String msg;
	private int statusCode;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
}
