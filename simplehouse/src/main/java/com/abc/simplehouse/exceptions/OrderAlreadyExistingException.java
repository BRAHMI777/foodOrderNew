/**
 * 
 */
package com.abc.simplehouse.exceptions;

/**
 * @author BrahmanandaReddy
 * 06-Jul-2021
 */
public class OrderAlreadyExistingException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
	public OrderAlreadyExistingException(String msg)
	{
		super(msg);
	}

}
