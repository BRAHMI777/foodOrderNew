/**
 * 
 */
package com.abc.simplehouse.exceptions;

/**
 * @author brahm
 * 11-Jul-2021
 */
public class AdminNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminNotFoundException(String msg)
	{
		super(msg);
	}

}
