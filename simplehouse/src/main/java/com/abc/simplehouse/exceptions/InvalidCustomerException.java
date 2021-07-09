/**
 * 
 */
package com.abc.simplehouse.exceptions;

/**
 * @author brahm
 * 09-Jul-2021
 */
public class InvalidCustomerException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
	public InvalidCustomerException(String msg)
	{
		super(msg);
	}

}
