/**
 * 
 */
package com.abc.simplehouse.exceptions;

/**
 * @author ajay naveen
 *
 */
public class CartItemNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String message;

	public CartItemNotFoundException(String message) {
		super(message);
	}

}
