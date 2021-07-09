/**
 * 
 */
package com.abc.simplehouse.exceptions;

/**
 * @author brahm
 * 09-Jul-2021
 */
public class CredentialsNotValidException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
	public CredentialsNotValidException(String msg)
	{
		super(msg);
	}

}
