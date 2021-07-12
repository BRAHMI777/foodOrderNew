/**
 * 
 */
package com.abc.simplehouse.exceptions;

/**
 * @author brahm
 * 11-Jul-2021
 */
public class AdminAlreadyExistingException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminAlreadyExistingException(String msg)
	{
		super(msg);
	}

}
