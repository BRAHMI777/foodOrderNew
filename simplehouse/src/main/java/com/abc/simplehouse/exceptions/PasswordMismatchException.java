/**
 * 
 */
package com.abc.simplehouse.exceptions;

/**
 * @author brahm
 * 10-Jul-2021
 */
public class PasswordMismatchException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
	public PasswordMismatchException(String msg)
	{
		super(msg);
	}

}
