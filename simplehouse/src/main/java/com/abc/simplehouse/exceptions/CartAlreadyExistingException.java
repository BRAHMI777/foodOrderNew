/**
 * 
 */
package com.abc.simplehouse.exceptions;

/**
 * @author ajay naveen
 *
 */

public class CartAlreadyExistingException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	String message;

	public CartAlreadyExistingException(String message) {
		super(message);
	}

}
