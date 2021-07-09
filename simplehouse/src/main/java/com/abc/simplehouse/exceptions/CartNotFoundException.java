/**
 * 
 */
package com.abc.simplehouse.exceptions;

/**
 * @author ajay naveen
 *
 */
public class CartNotFoundException extends RuntimeException {
	/**
	 * 
	 * @param msg
	 */
	private static final long serialVersionUID = 1L;

	 String msg;

	public CartNotFoundException(String msg) 
	{
		super(msg);
		}
	

}
