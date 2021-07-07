package com.abc.simplehouse.exceptions;

public class CustomerNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
	public CustomerNotFoundException(String msg)
	{
		super(msg);
	}

}
