/**
 * 
 */
package com.abc.simplehouse.exceptions;

/**
 * @author BrahmanandaReddy
 * 06-Jul-2021
 */
public class OrderNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
	public OrderNotFoundException(String msg)
	{
		super(msg);
	}
}
