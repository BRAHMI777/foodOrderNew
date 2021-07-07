/**
 * 
 */
package com.abc.simplehouse.exceptions;

/**
 * @author brahm
 * 07-Jul-2021
 */
public class PaymentAlreadyExistsException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
	public PaymentAlreadyExistsException(String msg)
	{
		super(msg);
	}

}
