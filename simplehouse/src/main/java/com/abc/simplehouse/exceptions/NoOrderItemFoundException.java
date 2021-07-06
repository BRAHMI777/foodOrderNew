/**
 * 
 */
package com.abc.simplehouse.exceptions;

/**
 * @author BrahmanandaReddy
 * 06-Jul-2021
 */
public class NoOrderItemFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
	public NoOrderItemFoundException(String msg)
	{
		super(msg);
	}

}
