package com.abc.simplehouse.exceptions;

public class PaymentDetailsNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
	public PaymentDetailsNotFoundException(String msg)
	{
		super(msg);
	}
	

}
