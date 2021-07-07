package com.abc.simplehouse.exceptions;

public class CustomerAlreadyExistsException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
	public CustomerAlreadyExistsException(String msg)
	{
		super(msg);
	}

}
